package B5;

import Q4.a;
import V4.i;
import V4.j;
import android.R;
import android.content.res.Resources;
import kotlin.jvm.internal.r;
import t2.AbstractC2654a;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Q4.a, j.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a.b f838d;

    public final int[] a(Resources resources) {
        return new int[]{resources.getColor(R.color.system_accent1_1000, null), resources.getColor(R.color.system_accent1_900, null), resources.getColor(R.color.system_accent1_800, null), resources.getColor(R.color.system_accent1_700, null), resources.getColor(R.color.system_accent1_600, null), resources.getColor(R.color.system_accent1_500, null), resources.getColor(R.color.system_accent1_400, null), resources.getColor(R.color.system_accent1_300, null), resources.getColor(R.color.system_accent1_200, null), resources.getColor(R.color.system_accent1_100, null), resources.getColor(R.color.system_accent1_50, null), resources.getColor(R.color.system_accent1_10, null), resources.getColor(R.color.system_accent1_0, null), resources.getColor(R.color.system_accent2_1000, null), resources.getColor(R.color.system_accent2_900, null), resources.getColor(R.color.system_accent2_800, null), resources.getColor(R.color.system_accent2_700, null), resources.getColor(R.color.system_accent2_600, null), resources.getColor(R.color.system_accent2_500, null), resources.getColor(R.color.system_accent2_400, null), resources.getColor(R.color.system_accent2_300, null), resources.getColor(R.color.system_accent2_200, null), resources.getColor(R.color.system_accent2_100, null), resources.getColor(R.color.system_accent2_50, null), resources.getColor(R.color.system_accent2_10, null), resources.getColor(R.color.system_accent2_0, null), resources.getColor(R.color.system_accent3_1000, null), resources.getColor(R.color.system_accent3_900, null), resources.getColor(R.color.system_accent3_800, null), resources.getColor(R.color.system_accent3_700, null), resources.getColor(R.color.system_accent3_600, null), resources.getColor(R.color.system_accent3_500, null), resources.getColor(R.color.system_accent3_400, null), resources.getColor(R.color.system_accent3_300, null), resources.getColor(R.color.system_accent3_200, null), resources.getColor(R.color.system_accent3_100, null), resources.getColor(R.color.system_accent3_50, null), resources.getColor(R.color.system_accent3_10, null), resources.getColor(R.color.system_accent3_0, null), resources.getColor(R.color.system_neutral1_1000, null), resources.getColor(R.color.system_neutral1_900, null), resources.getColor(R.color.system_neutral1_800, null), resources.getColor(R.color.system_neutral1_700, null), resources.getColor(R.color.system_neutral1_600, null), resources.getColor(R.color.system_neutral1_500, null), resources.getColor(R.color.system_neutral1_400, null), resources.getColor(R.color.system_neutral1_300, null), resources.getColor(R.color.system_neutral1_200, null), resources.getColor(R.color.system_neutral1_100, null), resources.getColor(R.color.system_neutral1_50, null), resources.getColor(R.color.system_neutral1_10, null), resources.getColor(R.color.system_neutral1_0, null), resources.getColor(R.color.system_neutral2_1000, null), resources.getColor(R.color.system_neutral2_900, null), resources.getColor(R.color.system_neutral2_800, null), resources.getColor(R.color.system_neutral2_700, null), resources.getColor(R.color.system_neutral2_600, null), resources.getColor(R.color.system_neutral2_500, null), resources.getColor(R.color.system_neutral2_400, null), resources.getColor(R.color.system_neutral2_300, null), resources.getColor(R.color.system_neutral2_200, null), resources.getColor(R.color.system_neutral2_100, null), resources.getColor(R.color.system_neutral2_50, null), resources.getColor(R.color.system_neutral2_10, null), resources.getColor(R.color.system_neutral2_0, null)};
    }

    @Override // Q4.a
    public void onAttachedToEngine(a.b flutterPluginBinding) {
        r.f(flutterPluginBinding, "flutterPluginBinding");
        j jVar = new j(flutterPluginBinding.b(), "io.material.plugins/dynamic_color");
        this.f837c = jVar;
        jVar.e(this);
        this.f838d = flutterPluginBinding;
    }

    @Override // Q4.a
    public void onDetachedFromEngine(a.b binding) {
        r.f(binding, "binding");
        j jVar = this.f837c;
        if (jVar == null) {
            r.s("channel");
            jVar = null;
        }
        jVar.e(null);
    }

    @Override // V4.j.c
    public void onMethodCall(i call, j.d result) {
        r.f(call, "call");
        r.f(result, "result");
        if (!r.b(call.f5332a, "getCorePalette")) {
            result.c();
            return;
        }
        a.b bVar = null;
        if (!AbstractC2654a.a()) {
            result.a(null);
            return;
        }
        a.b bVar2 = this.f838d;
        if (bVar2 == null) {
            r.s("binding");
        } else {
            bVar = bVar2;
        }
        Resources resources = bVar.a().getResources();
        r.e(resources, "getResources(...)");
        result.a(a(resources));
    }
}
