package v;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f10584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Configuration f10585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10586c;

    public j(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f10584a = colorStateList;
        this.f10585b = configuration;
        this.f10586c = theme == null ? 0 : theme.hashCode();
    }
}
