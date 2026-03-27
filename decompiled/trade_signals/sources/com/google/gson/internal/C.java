package com.google.gson.internal;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public abstract class C {
    public static boolean a(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }
}
