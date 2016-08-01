package com.sxx.ioc.ann.bean;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.TYPE) 
public @interface MyClassAnnotation
{
    String uri();
    String desc();
}
