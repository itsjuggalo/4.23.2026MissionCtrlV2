package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public class zzaex {
    private zzaex() {
    }

    public static Object zza(String str, Type type) throws zzacn {
        if (type != String.class) {
            if (type == Void.class) {
                return null;
            }
            try {
                try {
                    return ((zzaez) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0])).zza(str);
                } catch (Exception e) {
                    throw new zzacn(AbstractC1024h.b("Json conversion failed! ", e.getMessage()), e);
                }
            } catch (Exception e2) {
                throw new zzacn("Instantiation of JsonResponse failed! ".concat(String.valueOf(type)), e2);
            }
        }
        try {
            zzagt zzagtVar = (zzagt) new zzagt().zza(str);
            if (zzagtVar.zzb()) {
                return zzagtVar.zza();
            }
            throw new zzacn("No error message: " + str);
        } catch (Exception e6) {
            throw new zzacn(AbstractC1024h.b("Json conversion failed! ", e6.getMessage()), e6);
        }
    }
}
