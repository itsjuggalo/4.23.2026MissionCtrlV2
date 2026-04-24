package f4;

import e3.w;

/* JADX INFO: loaded from: classes.dex */
public interface k {
    static void a(Z3.f fVar, e eVar) {
        l lVar = l.f6494d;
        Object obj = null;
        w wVar = new w(13, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeApp", fVar, lVar, obj);
        if (eVar != null) {
            wVar.L(new i(eVar, 3));
        } else {
            wVar.L(null);
        }
        w wVar2 = new w(13, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeCore", fVar, lVar, obj);
        if (eVar != null) {
            wVar2.L(new i(eVar, 4));
        } else {
            wVar2.L(null);
        }
        w wVar3 = new w(13, "dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.optionsFromResource", fVar, lVar, obj);
        if (eVar != null) {
            wVar3.L(new i(eVar, 5));
        } else {
            wVar3.L(null);
        }
    }
}
