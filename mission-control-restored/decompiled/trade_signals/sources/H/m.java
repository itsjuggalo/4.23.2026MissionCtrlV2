package H;

import H.i;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3508a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3509b = new Object();

    public static Bundle a(i.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.m() : 0);
        bundle.putCharSequence(com.amazon.a.a.o.b.f14041S, aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    public static Bundle b(t tVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", tVar.i());
        bundle.putCharSequence("label", tVar.h());
        bundle.putCharSequenceArray("choices", tVar.e());
        bundle.putBoolean("allowFreeFormInput", tVar.c());
        bundle.putBundle("extras", tVar.g());
        Set setD = tVar.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] c(t[] tVarArr) {
        if (tVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[tVarArr.length];
        for (int i8 = 0; i8 < tVarArr.length; i8++) {
            bundleArr[i8] = b(tVarArr[i8]);
        }
        return bundleArr;
    }
}
