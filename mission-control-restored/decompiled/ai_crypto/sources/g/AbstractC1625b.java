package g;

import F5.AbstractC0556n;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: g.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1625b extends AbstractC1624a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14231a = new a(null);

    /* JADX INFO: renamed from: g.b$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final List a(Intent intent) {
            r.f(intent, "<this>");
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Uri data = intent.getData();
            if (data != null) {
                linkedHashSet.add(data);
            }
            ClipData clipData = intent.getClipData();
            if (clipData == null && linkedHashSet.isEmpty()) {
                return AbstractC0556n.g();
            }
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i7 = 0; i7 < itemCount; i7++) {
                    Uri uri = clipData.getItemAt(i7).getUri();
                    if (uri != null) {
                        linkedHashSet.add(uri);
                    }
                }
            }
            return new ArrayList(linkedHashSet);
        }

        public a() {
        }
    }
}
