package io.flutter.plugins.sharedpreferences;

import cd.h0;
import java.util.List;
import kotlin.Metadata;
import ng.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lng/n0;", "", "", "", "<anonymous>", "(Lng/n0;)Ljava/util/Map;"}, k = 3, mv = {2, 1, 0})
@id.f(c = "io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin$getKeys$prefs$1", f = "SharedPreferencesPlugin.kt", l = {248}, m = "invokeSuspend")
public final class SharedPreferencesPlugin$getKeys$prefs$1 extends id.m implements pd.o {
    final /* synthetic */ List<String> $allowList;
    int label;
    final /* synthetic */ SharedPreferencesPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesPlugin$getKeys$prefs$1(SharedPreferencesPlugin sharedPreferencesPlugin, List<String> list, gd.e eVar) {
        super(2, eVar);
        this.this$0 = sharedPreferencesPlugin;
        this.$allowList = list;
    }

    @Override // id.a
    public final gd.e create(Object obj, gd.e eVar) {
        return new SharedPreferencesPlugin$getKeys$prefs$1(this.this$0, this.$allowList, eVar);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = hd.c.f();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cd.s.b(obj);
            return obj;
        }
        cd.s.b(obj);
        SharedPreferencesPlugin sharedPreferencesPlugin = this.this$0;
        List<String> list = this.$allowList;
        this.label = 1;
        Object prefs = sharedPreferencesPlugin.getPrefs(list, this);
        return prefs == objF ? objF : prefs;
    }

    @Override // pd.o
    public final Object invoke(n0 n0Var, gd.e eVar) {
        return ((SharedPreferencesPlugin$getKeys$prefs$1) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
    }
}
