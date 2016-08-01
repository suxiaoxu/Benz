package com.sxx.ann.study;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD) 
public @interface MyFieldAnnotation 
{
    String uri();
    String desc();
}
