package p0;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f18169a;

    public i(Object obj) {
        this.f18169a = (LocaleList) obj;
    }

    @Override // p0.h
    public String a() {
        return this.f18169a.toLanguageTags();
    }

    @Override // p0.h
    public Object b() {
        return this.f18169a;
    }

    public boolean equals(Object obj) {
        return this.f18169a.equals(((h) obj).b());
    }

    @Override // p0.h
    public Locale get(int i10) {
        return this.f18169a.get(i10);
    }

    public int hashCode() {
        return this.f18169a.hashCode();
    }

    @Override // p0.h
    public int size() {
        return this.f18169a.size();
    }

    public String toString() {
        return this.f18169a.toString();
    }
}
