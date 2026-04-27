package f4;

import e3.w;

/* JADX INFO: loaded from: classes.dex */
public interface j {
    static void b(Z3.f fVar, e eVar) {
        l lVar = l.f6494d;
        Object obj = null;
        w wVar = new w(13, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticDataCollectionEnabled", fVar, lVar, obj);
        if (eVar != null) {
            wVar.L(new i(eVar, 0));
        } else {
            wVar.L(null);
        }
        w wVar2 = new w(13, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticResourceManagementEnabled", fVar, lVar, obj);
        if (eVar != null) {
            wVar2.L(new i(eVar, 1));
        } else {
            wVar2.L(null);
        }
        w wVar3 = new w(13, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.delete", fVar, lVar, obj);
        if (eVar != null) {
            wVar3.L(new i(eVar, 2));
        } else {
            wVar3.L(null);
        }
    }
}
