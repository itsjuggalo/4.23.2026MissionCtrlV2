package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class zzaex {
    private zzaex() {
    }

    public static Object zza(String str, Type type) throws zzacn {
        if (type == String.class) {
            try {
                zzagt zzagtVar = (zzagt) new zzagt().zza(str);
                if (zzagtVar.zzb()) {
                    return zzagtVar.zza();
                }
                throw new zzacn("No error message: " + str);
            } catch (Exception e10) {
                throw new zzacn("Json conversion failed! " + e10.getMessage(), e10);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            try {
                return ((zzaez) ((Class) type).getConstructor(null).newInstance(null)).zza(str);
            } catch (Exception e11) {
                throw new zzacn("Json conversion failed! " + e11.getMessage(), e11);
            }
        } catch (Exception e12) {
            throw new zzacn("Instantiation of JsonResponse failed! " + String.valueOf(type), e12);
        }
    }
}
