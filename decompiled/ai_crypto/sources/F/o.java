package F;

import F.k;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f1823a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1824b = new Object();

    public static Bundle a(k.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.m() : 0);
        bundle.putCharSequence(com.amazon.a.a.o.b.f9930S, aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    public static Bundle b(v vVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", vVar.i());
        bundle.putCharSequence("label", vVar.h());
        bundle.putCharSequenceArray("choices", vVar.e());
        bundle.putBoolean("allowFreeFormInput", vVar.c());
        bundle.putBundle("extras", vVar.g());
        Set setD = vVar.d();
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

    public static Bundle[] c(v[] vVarArr) {
        if (vVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[vVarArr.length];
        for (int i7 = 0; i7 < vVarArr.length; i7++) {
            bundleArr[i7] = b(vVarArr[i7]);
        }
        return bundleArr;
    }
}
