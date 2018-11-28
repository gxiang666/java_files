package com.tnti.AnnotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD, ElementType.TYPE})
public @interface TestAnnotation {

}
