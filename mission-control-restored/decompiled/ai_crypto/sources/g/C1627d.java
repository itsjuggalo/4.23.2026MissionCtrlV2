package g;

import F5.AbstractC0556n;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.provider.MediaStore;
import f.C1541h;
import g.AbstractC1624a;
import g.f;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: g.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1627d extends AbstractC1624a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14232b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14233a;

    /* JADX INFO: renamed from: g.d$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
        }
    }

    public C1627d(int i7) {
        this.f14233a = i7;
        if (i7 <= 1) {
            throw new IllegalArgumentException("Max items must be higher than 1");
        }
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, C1541h input) {
        r.f(context, "context");
        r.f(input, "input");
        f.a aVar = f.f14234a;
        if (aVar.f()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.c(input.a()));
            if (this.f14233a > MediaStore.getPickImagesMaxLimit()) {
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()");
            }
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.f14233a);
            return intent;
        }
        if (aVar.e(context)) {
            ResolveInfo resolveInfoB = aVar.b(context);
            if (resolveInfoB == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo = resolveInfoB.activityInfo;
            Intent intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent2.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent2.setType(aVar.c(input.a()));
            intent2.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", this.f14233a);
            return intent2;
        }
        if (aVar.d(context)) {
            ResolveInfo resolveInfoA = aVar.a(context);
            if (resolveInfoA == null) {
                throw new IllegalStateException("Required value was null.");
            }
            ActivityInfo activityInfo2 = resolveInfoA.activityInfo;
            Intent intent3 = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent3.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent3.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.f14233a);
            return intent3;
        }
        Intent intent4 = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent4.setType(aVar.c(input.a()));
        intent4.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        if (intent4.getType() != null) {
            return intent4;
        }
        intent4.setType("*/*");
        intent4.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
        return intent4;
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final AbstractC1624a.C0243a b(Context context, C1541h input) {
        r.f(context, "context");
        r.f(input, "input");
        return null;
    }

    @Override // g.AbstractC1624a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List c(int i7, Intent intent) {
        List listA;
        if (i7 != -1) {
            intent = null;
        }
        return (intent == null || (listA = AbstractC1625b.f14231a.a(intent)) == null) ? AbstractC0556n.g() : listA;
    }
}
