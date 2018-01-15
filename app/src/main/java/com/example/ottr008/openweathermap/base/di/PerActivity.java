package com.example.ottr008.openweathermap.base.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by nikhil on 15/1/18.
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
