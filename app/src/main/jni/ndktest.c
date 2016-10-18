#include <jni.h>
#include <stdio.h>
#include <string.h>
unsigned int *int32result;
jstring Java_com_buzz_jniboxbox_MainActivity_helloWorld
        (JNIEnv* env, jobject obj) {
    return (*env)->NewStringUTF(env, "Hello World KENG");
}


//Convert Celsius to Fahrenheit
//Used formula from this web (http://www.almanac.com/content/temperature-conversion)
jdouble Java_com_buzz_jniboxbox_MainActivity_Converter
        (JNIEnv* env, jobject obj, jdouble x) {
    x = (x*1.8) + 32;
    return  x;
}

jdouble Java_com_buzz_jniboxbox_Conversion_Converter
        (JNIEnv* env, jobject obj, jdouble x) {
    x = (x*1.8) + 32;
    return  x;
}



