package D;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f297a;

    public i(Object obj) {
        this.f297a = (LocaleList) obj;
    }

    @Override // D.h
    public String a() {
        return this.f297a.toLanguageTags();
    }

    @Override // D.h
    public Object b() {
        return this.f297a;
    }

    public boolean equals(Object obj) {
        return this.f297a.equals(((h) obj).b());
    }

    @Override // D.h
    public Locale get(int i4) {
        return this.f297a.get(i4);
    }

    public int hashCode() {
        return this.f297a.hashCode();
    }

    @Override // D.h
    public boolean isEmpty() {
        return this.f297a.isEmpty();
    }

    @Override // D.h
    public int size() {
        return this.f297a.size();
    }

    public String toString() {
        return this.f297a.toString();
    }
}
