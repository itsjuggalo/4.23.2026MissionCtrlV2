package P;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f6255a;

    public i(Object obj) {
        this.f6255a = (LocaleList) obj;
    }

    @Override // P.h
    public String a() {
        return this.f6255a.toLanguageTags();
    }

    @Override // P.h
    public Object b() {
        return this.f6255a;
    }

    public boolean equals(Object obj) {
        return this.f6255a.equals(((h) obj).b());
    }

    @Override // P.h
    public Locale get(int i8) {
        return this.f6255a.get(i8);
    }

    public int hashCode() {
        return this.f6255a.hashCode();
    }

    @Override // P.h
    public int size() {
        return this.f6255a.size();
    }

    public String toString() {
        return this.f6255a.toString();
    }
}
