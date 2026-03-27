package io.flutter.plugins.sharedpreferences;

import Y6.L;
import java.util.List;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;
import u5.InterfaceC2779f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC2779f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getKeys$prefs$1", f = "SharedPreferencesPlugin.kt", l = {248}, m = "invokeSuspend")
public final class SharedPreferencesPlugin$getKeys$prefs$1 extends AbstractC2785l implements B5.o {
    final /* synthetic */ List<String> $allowList;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getKeys$prefs$1(SharedPreferencesPlugin sharedPreferencesPlugin, List<String> list, InterfaceC2707e interfaceC2707e) {
        super(2, interfaceC2707e);
        this.this$0 = sharedPreferencesPlugin;
        this.$allowList = list;
    }

    @Override // u5.AbstractC2774a
    public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
        return new SharedPreferencesPlugin$getKeys$prefs$1(this.this$0, this.$allowList, interfaceC2707e);
    }

    @Override // B5.o
    public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
        return ((SharedPreferencesPlugin$getKeys$prefs$1) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
    }

    @Override // u5.AbstractC2774a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = AbstractC2751c.f();
        int i8 = this.label;
        if (i8 == 0) {
            AbstractC2491s.b(obj);
            SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
            List<String> list = this.$allowList;
            this.label = 1;
            obj = sharedPreferencesPlugin.getPrefs(list, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i8 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC2491s.b(obj);
        }
        return obj;
    }
}
