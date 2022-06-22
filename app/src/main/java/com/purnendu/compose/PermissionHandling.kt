package com.purnendu.compose

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

class PermissionHandling : ComponentActivity() {

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val permissionState = rememberMultiplePermissionsState(
                permissions = listOf(
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.CAMERA
                )
            )

            val lifeCycleOwner = LocalLifecycleOwner.current
            DisposableEffect(key1 = lifeCycleOwner)
            {
                val observer = LifecycleEventObserver { _, event ->
                    if (event == Lifecycle.Event.ON_START) {
                        permissionState.launchMultiplePermissionRequest()
                    }
                }
                lifeCycleOwner.lifecycle.addObserver(observer)

                onDispose {
                    lifeCycleOwner.lifecycle.removeObserver(observer)
                }
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {


                permissionState.permissions.forEach { permission ->
                    when (permission.permission) {
                        Manifest.permission.CAMERA -> {

                            when {
                                permission.status.isGranted -> {
                                    Text(text = "Camera permission accepted")
                                }
                                permission.status.shouldShowRationale -> {
                                    Text(text = "Camera permission is needed to access camera")
                                }
                                !permission.status.isGranted && !permission.status.shouldShowRationale -> {
                                    Text(text = "Camera permission permanently denied ,you can enable it by going to app setting")
                                }

                            }


                        }
                        Manifest.permission.RECORD_AUDIO -> {
                            when {
                                permission.status.isGranted -> {
                                    Text(text = "Record Audio permission accepted")
                                }
                                permission.status.shouldShowRationale -> {
                                    Text(text = "Audio permission is needed to access microphone")
                                }
                                !permission.status.isGranted && !permission.status.shouldShowRationale -> {
                                    Text(text = "Recording permission permanently denied ,you can enable it by going to app setting")
                                }

                            }
                        }
                    }
                }
            }


        }
    }
}