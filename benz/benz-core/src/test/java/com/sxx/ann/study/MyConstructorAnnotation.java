package com.sxx.ann.study;

import java.lang.annotation.Retention;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.CONSTRUCTOR) 
public @interface MyConstructorAnnotation 
{
    String uri();
    String desc();
}
