#include <jni.h>
#include <stdio.h>
#include <string.h>
unsigned int *int32result;
jstring Java_com_buzz_jniboxbox_MainActivity_helloWorld
        (JNIEnv* env, jobject obj) {
    return (*env)->NewStringUTF(env, "Hello World KENG");
}


jdouble Java_com_buzz_jniboxbox_MainActivity_Converter
        (JNIEnv* env, jobject obj, jdouble x) {
    x = (x*1.8) + 32;
    return  x;
}


