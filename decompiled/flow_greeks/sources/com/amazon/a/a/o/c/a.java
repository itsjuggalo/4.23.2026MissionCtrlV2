package com.amazon.a.a.o.c;

import com.amazon.a.a.o.c;
import com.amazon.a.a.o.c.a.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f4608a = new c("Serializer");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class[] f4609b = {com.amazon.a.a.b.c.class, String.class, HashMap.class, LinkedHashMap.class};

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
                } catch (IOException e10) {
                    e = e10;
                    if (c.f4604b) {
                        f4608a.b("Could not serialize object: " + serializable, e);
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
        } catch (IOException e11) {
            e = e11;
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            com.amazon.a.a.o.a.a(objectOutputStream2);
            throw th;
        }
    }

    public static <T> T a(String str) throws Throwable {
        f fVar;
        f fVar2 = null;
        if (str != null && str.length() != 0) {
            try {
                try {
                    fVar = new f(new ByteArrayInputStream(com.amazon.c.a.a.c.c(str.getBytes())));
                    try {
                        try {
                            fVar.a(f4609b);
                            T t10 = (T) fVar.readObject();
                            com.amazon.a.a.o.a.a(fVar);
                            return t10;
                        } catch (Exception e10) {
                            e = e10;
                            if (c.f4604b) {
                                f4608a.b("Could not read object from string: " + str, e);
                            }
                            com.amazon.a.a.o.a.a(fVar);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fVar2 = fVar;
                        com.amazon.a.a.o.a.a(fVar2);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    fVar = null;
                } catch (Throwable th2) {
                    th = th2;
                    com.amazon.a.a.o.a.a(fVar2);
                    throw th;
                }
            } catch (IOException e12) {
                if (c.f4604b) {
                    f4608a.b("Could not decode string", e12);
                }
            }
        }
        return null;
    }
}
