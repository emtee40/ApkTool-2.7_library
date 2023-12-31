package com.mcal.example.utils

import brut.androlib.Androlib
import brut.androlib.ApkDecoder
import com.mcal.androlib.options.BuildOptions
import com.mcal.androlib.utils.Logger
import java.io.File

object ApkToolHelper {
    /**
     * @param toolsDir путь к директории с бинарниками и фреймфорками:
     *      ../toolsDir/1.apk
     *      ../toolsDir/android-framework.jar
     *      ../toolsDir/aapt
     *      ../toolsDir/aapt2
     */
    fun decode(apkPath: File, decodeRootPath: File, toolsDir: String, logger: Logger) {
        try {
            ApkDecoder(apkPath, Androlib(BuildOptions().apply {
                frameworkFolderLocation = toolsDir
                aaptPath = toolsDir + File.separator + "aapt"
                aapt2Path = toolsDir + File.separator + "aapt2"
                useNewBuildRules = true
                ignoreMultiRes = false
            }, logger)).apply {
                setApkFile(apkPath)
                setBaksmaliDebugMode(false)
                setFrameworkDir(toolsDir)
                setDecodeResources(ApkDecoder.DECODE_RESOURCES_FULL)
                setDecodeSources(ApkDecoder.DECODE_SOURCES_SMALI)
                setOutDir(decodeRootPath)
                setApiLevel(14)
                setForceDelete(true)
            }.decode()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun buildProject(apkPath: File, decodeRootPath: File, toolsDir: String, logger: Logger) {
        Androlib(BuildOptions().apply {
            useNewBuildRules = true
            useAapt2 = true
            aaptPath = toolsDir + File.separator + "aapt"
            aapt2Path = toolsDir + File.separator + "aapt2"
            frameworkFolderLocation = toolsDir
            ignoreMultiRes = true
        }, logger).build(decodeRootPath, apkPath)
    }
}