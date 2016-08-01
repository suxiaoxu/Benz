package com.sxx.ann.study;

import java.lang.annotation.Retention;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE) 
public @interface MyClassAnnotation 
{
    String uri();
    String desc();
}
