package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.material.timepicker.a f11833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.material.timepicker.a f11834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11839g;

    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i7) {
            return new d[i7];
        }
    }

    public d(int i7, int i8, int i9, int i10) {
        this.f11836d = i7;
        this.f11837e = i8;
        this.f11838f = i9;
        this.f11835c = i10;
        this.f11839g = d(i7);
        this.f11833a = new com.google.android.material.timepicker.a(59);
        this.f11834b = new com.google.android.material.timepicker.a(i10 == 1 ? 24 : 12);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return c(resources, charSequence, "%02d");
    }

    public static String c(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public static int d(int i7) {
        return i7 >= 12 ? 1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f11836d == dVar.f11836d && this.f11837e == dVar.f11837e && this.f11835c == dVar.f11835c && this.f11838f == dVar.f11838f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11835c), Integer.valueOf(this.f11836d), Integer.valueOf(this.f11837e), Integer.valueOf(this.f11838f)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        parcel.writeInt(this.f11836d);
        parcel.writeInt(this.f11837e);
        parcel.writeInt(this.f11838f);
        parcel.writeInt(this.f11835c);
    }

    public d(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
