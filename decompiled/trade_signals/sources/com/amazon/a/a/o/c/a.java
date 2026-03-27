package com.amazon.a.a.o.c;

import com.amazon.a.a.o.c;
import com.amazon.a.a.o.c.a.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f14110a = new c("Serializer");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class[] f14111b = {com.amazon.a.a.b.c.class, String.class, HashMap.class, LinkedHashMap.class};

    public static <T> T a(String str) throws Throwable {
        f fVar;
        Object obj;
        InputStream inputStream = (T) null;
        if (str != null && str.length() != 0) {
            try {
                try {
                    fVar = new f(new ByteArrayInputStream(com.amazon.c.a.a.c.c(str.getBytes())));
                    try {
                        try {
                            fVar.a(f14111b);
                            obj = (T) fVar.readObject();
                        } catch (Exception e8) {
                            e = e8;
                            obj = inputStream;
                            if (c.f14106b) {
                                f14110a.b("Could not read object from string: " + str, e);
                                obj = inputStream;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = (T) fVar;
                        com.amazon.a.a.o.a.a(inputStream);
                        throw th;
                    }
                } catch (Exception e9) {
                    e = e9;
                    fVar = null;
                } catch (Throwable th2) {
                    th = th2;
                    com.amazon.a.a.o.a.a(inputStream);
                    throw th;
                }
                com.amazon.a.a.o.a.a(fVar);
                return (T) obj;
            } catch (IOException e10) {
                if (c.f14106b) {
                    f14110a.b("Could not decode string", e10);
                }
            }
        }
        return null;
    }

    public static String a(Serializable serializable) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        if (serializable == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                try {
                    objectOutputStream.writeObject(serializable);
                    String strA = com.amazon.c.a.a.c.a(byteArrayOutputStream.toByteArray());
                    com.amazon.a.a.o.a.a(objectOutputStream);
                    return strA;
                } catch (IOException e8) {
                    e = e8;
                    if (c.f14106b) {
                        f14110a.b("Could not serialize object: " + serializable, e);
                    }
                    com.amazon.a.a.o.a.a(objectOutputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                com.amazon.a.a.o.a.a(objectOutputStream2);
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.amazon.a.a.o.a.a(objectOutputStream2);
            throw th;
        }
    }
}
