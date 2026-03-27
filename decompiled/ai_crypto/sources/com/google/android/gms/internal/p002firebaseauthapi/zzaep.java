package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class zzaep {
    private zzaep() {
    }

    public static Object zza(String str, Type type) throws zzaci {
        if (type == String.class) {
            try {
                zzagl zzaglVar = (zzagl) new zzagl().zza(str);
                if (zzaglVar.zzb()) {
                    return zzaglVar.zza();
                }
                throw new zzaci("No error message: " + str);
            } catch (Exception e7) {
                throw new zzaci("Json conversion failed! " + e7.getMessage(), e7);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            try {
                return ((zzaer) ((Class) type).getConstructor(null).newInstance(null)).zza(str);
            } catch (Exception e8) {
                throw new zzaci("Json conversion failed! " + e8.getMessage(), e8);
            }
        } catch (Exception e9) {
            throw new zzaci("Instantiation of JsonResponse failed! " + String.valueOf(type), e9);
        }
    }
}
