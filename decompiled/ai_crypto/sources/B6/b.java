package B6;

import B4.e;
import B4.g;
import V4.i;
import V4.j;
import V4.l;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.view.WindowInsetsController;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import x0.AbstractC2815b;

/* JADX INFO: loaded from: classes2.dex */
public class b implements l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f841e = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j.d f842f;

    public b(Activity activity) {
        this.f839c = activity;
        this.f840d = AbstractC2815b.a(activity.getApplicationContext());
    }

    private void e(String str) {
        j.d dVar = this.f842f;
        if (dVar != null) {
            dVar.a(str);
            b();
        }
    }

    public final void a(String str) {
        SharedPreferences.Editor editorEdit = this.f840d.edit();
        editorEdit.putString("imagecropper.FILENAME_CACHE_KEY", str);
        editorEdit.apply();
    }

    public final void b() {
        this.f842f = null;
    }

    public final int c(int i7) {
        float[] fArr = new float[3];
        Color.colorToHSV(i7, fArr);
        fArr[2] = fArr[2] * 0.8f;
        return Color.HSVToColor(fArr);
    }

    public final void d(String str, String str2, Throwable th) {
        j.d dVar = this.f842f;
        if (dVar != null) {
            dVar.b(str, str2, th);
            b();
        }
    }

    public final String f() {
        if (!this.f840d.contains("imagecropper.FILENAME_CACHE_KEY")) {
            return null;
        }
        String string = this.f840d.getString("imagecropper.FILENAME_CACHE_KEY", "");
        SharedPreferences.Editor editorEdit = this.f840d.edit();
        editorEdit.remove("imagecropper.FILENAME_CACHE_KEY");
        editorEdit.apply();
        return string;
    }

    public final D4.a g(Map map) {
        String string = map.containsKey("name") ? map.get("name").toString() : null;
        Object obj = map.containsKey("data") ? map.get("data") : null;
        boolean z7 = obj instanceof Map;
        return ("original".equals(string) || (z7 ? Integer.valueOf(Integer.parseInt(((Map) obj).get("ratio_x").toString())) : null) == null) ? new D4.a(this.f839c.getString(e.f767a), 0.0f, 1.0f) : new D4.a(string, r3.intValue() * 1.0f, (z7 ? Integer.valueOf(Integer.parseInt(((Map) obj).get("ratio_y").toString())) : null).intValue() * 1.0f);
    }

    public void h(i iVar, j.d dVar) {
        dVar.a(f());
    }

    public final g.a i(g.a aVar, i iVar) {
        String str = (String) iVar.a("android.toolbar_title");
        Integer num = (Integer) iVar.a("android.toolbar_color");
        Integer num2 = (Integer) iVar.a("android.statusbar_color");
        Integer num3 = (Integer) iVar.a("android.toolbar_widget_color");
        Integer num4 = (Integer) iVar.a("android.background_color");
        Integer num5 = (Integer) iVar.a("android.active_controls_widget_color");
        Integer num6 = (Integer) iVar.a("android.dimmed_layer_color");
        Integer num7 = (Integer) iVar.a("android.crop_frame_color");
        Integer num8 = (Integer) iVar.a("android.crop_grid_color");
        Integer num9 = (Integer) iVar.a("android.crop_frame_stroke_width");
        Integer num10 = (Integer) iVar.a("android.crop_grid_row_count");
        Integer num11 = (Integer) iVar.a("android.crop_grid_column_count");
        Integer num12 = (Integer) iVar.a("android.crop_grid_stroke_width");
        Boolean bool = (Boolean) iVar.a("android.show_crop_grid");
        Boolean bool2 = (Boolean) iVar.a("android.lock_aspect_ratio");
        Boolean bool3 = (Boolean) iVar.a("android.hide_bottom_controls");
        if (str != null) {
            aVar.u(str);
        }
        if (num != null) {
            aVar.t(num.intValue());
        }
        if (Build.VERSION.SDK_INT >= 31) {
            WindowInsetsController insetsController = this.f839c.getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsAppearance(8, 8);
                this.f839c.getWindow().setStatusBarColor(num2 != null ? num2.intValue() : 0);
            }
        } else if (num2 != null) {
            aVar.s(num2.intValue());
        } else if (num != null) {
            aVar.s(c(num.intValue()));
        }
        if (num3 != null) {
            aVar.v(num3.intValue());
        }
        if (num4 != null) {
            aVar.q(num4.intValue());
        }
        if (num5 != null) {
            aVar.b(num5.intValue());
        }
        if (num6 != null) {
            aVar.m(num6.intValue());
        }
        if (num7 != null) {
            aVar.g(num7.intValue());
        }
        if (num8 != null) {
            aVar.i(num8.intValue());
        }
        if (num9 != null) {
            aVar.h(num9.intValue());
        }
        if (num10 != null) {
            aVar.k(num10.intValue());
        }
        if (num11 != null) {
            aVar.j(num11.intValue());
        }
        if (num12 != null) {
            aVar.l(num12.intValue());
        }
        if (bool != null) {
            aVar.r(bool.booleanValue());
        }
        if (bool2 != null) {
            aVar.n(!bool2.booleanValue());
        }
        if (bool3 != null) {
            aVar.o(bool3.booleanValue());
        }
        return aVar;
    }

    public void j(i iVar, j.d dVar) {
        Integer num;
        Double d7;
        Double d8;
        File file;
        String str = (String) iVar.a("source_path");
        Integer num2 = (Integer) iVar.a("max_width");
        Integer num3 = (Integer) iVar.a("max_height");
        Double d9 = (Double) iVar.a("ratio_x");
        Double d10 = (Double) iVar.a("ratio_y");
        String str2 = (String) iVar.a("compress_format");
        Integer num4 = (Integer) iVar.a("compress_quality");
        ArrayList arrayList = (ArrayList) iVar.a("android.aspect_ratio_presets");
        String str3 = (String) iVar.a("android.crop_style");
        String str4 = (String) iVar.a("android.init_aspect_ratio");
        this.f842f = dVar;
        File cacheDir = this.f839c.getCacheDir();
        if ("png".equals(str2)) {
            d8 = d10;
            StringBuilder sb = new StringBuilder();
            sb.append("image_cropper_");
            num = num3;
            d7 = d9;
            sb.append(new Date().getTime());
            sb.append(".png");
            file = new File(cacheDir, sb.toString());
        } else {
            num = num3;
            d7 = d9;
            d8 = d10;
            file = new File(cacheDir, "image_cropper_" + new Date().getTime() + ".jpg");
        }
        Uri uriFromFile = Uri.fromFile(new File(str));
        Uri uriFromFile2 = Uri.fromFile(file);
        g.a aVar = new g.a();
        aVar.e("png".equals(str2) ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG);
        aVar.f(num4 != null ? num4.intValue() : 90);
        aVar.p(10000);
        if ("circle".equals(str3)) {
            aVar.d(true);
        }
        i(aVar, iVar);
        if (arrayList != null && str4 != null) {
            ArrayList arrayList2 = new ArrayList();
            int i7 = 0;
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                Map map = (Map) arrayList.get(i8);
                if (map != null) {
                    D4.a aVarG = g(map);
                    String strA = aVarG.a();
                    arrayList2.add(aVarG);
                    if (str4.equals(strA)) {
                        i7 = i8;
                    }
                }
            }
            aVar.c(i7, (D4.a[]) arrayList2.toArray(new D4.a[0]));
        }
        g gVarG = g.d(uriFromFile, uriFromFile2).g(aVar);
        if (num2 != null && num != null) {
            gVarG.f(num2.intValue(), num.intValue());
        }
        if (d7 != null && d8 != null) {
            gVarG.e(d7.floatValue(), d8.floatValue());
        }
        Activity activity = this.f839c;
        activity.startActivityForResult(gVarG.b(activity), 69);
    }

    @Override // V4.l
    public boolean onActivityResult(int i7, int i8, Intent intent) {
        if (i7 != 69) {
            return false;
        }
        if (i8 == -1) {
            String strE = this.f841e.e(this.f839c, g.c(intent));
            a(strE);
            e(strE);
            return true;
        }
        if (i8 == 96) {
            Throwable thA = g.a(intent);
            d("crop_error", thA.getLocalizedMessage(), thA);
            return true;
        }
        j.d dVar = this.f842f;
        if (dVar == null) {
            return false;
        }
        dVar.a(null);
        b();
        return true;
    }
}
