package com.sxx.ann.study;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
public @interface MyMethodAnnotation 
{
    String uri();
    String desc();
}
