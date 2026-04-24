package p;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class b0 extends K {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f21339c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f21340b;

    public b0(Context context, Resources resources) {
        super(resources);
        this.f21340b = new WeakReference(context);
    }

    public static boolean b() {
        return f21339c;
    }

    public static boolean c() {
        b();
        return false;
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getAnimation(int i7) {
        return super.getAnimation(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ boolean getBoolean(int i7) {
        return super.getBoolean(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getColor(int i7) {
        return super.getColor(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ ColorStateList getColorStateList(int i7) {
        return super.getColorStateList(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ Configuration getConfiguration() {
        return super.getConfiguration();
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ float getDimension(int i7) {
        return super.getDimension(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getDimensionPixelOffset(int i7) {
        return super.getDimensionPixelOffset(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getDimensionPixelSize(int i7) {
        return super.getDimensionPixelSize(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawable(int i7, Resources.Theme theme) {
        return super.getDrawable(i7, theme);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i7, int i8) {
        return super.getDrawableForDensity(i7, i8);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ float getFraction(int i7, int i8, int i9) {
        return super.getFraction(i7, i8, i9);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getIdentifier(String str, String str2, String str3) {
        return super.getIdentifier(str, str2, str3);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ int[] getIntArray(int i7) {
        return super.getIntArray(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getInteger(int i7) {
        return super.getInteger(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getLayout(int i7) {
        return super.getLayout(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ Movie getMovie(int i7) {
        return super.getMovie(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getQuantityString(int i7, int i8) {
        return super.getQuantityString(i7, i8);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getQuantityText(int i7, int i8) {
        return super.getQuantityText(i7, i8);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceEntryName(int i7) {
        return super.getResourceEntryName(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceName(int i7) {
        return super.getResourceName(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourcePackageName(int i7) {
        return super.getResourcePackageName(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceTypeName(int i7) {
        return super.getResourceTypeName(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getString(int i7) {
        return super.getString(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String[] getStringArray(int i7) {
        return super.getStringArray(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getText(int i7) {
        return super.getText(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence[] getTextArray(int i7) {
        return super.getTextArray(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(int i7, TypedValue typedValue, boolean z7) {
        super.getValue(i7, typedValue, z7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValueForDensity(int i7, int i8, TypedValue typedValue, boolean z7) {
        super.getValueForDensity(i7, i8, typedValue, z7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getXml(int i7) {
        return super.getXml(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ TypedArray obtainTypedArray(int i7) {
        return super.obtainTypedArray(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ InputStream openRawResource(int i7) {
        return super.openRawResource(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ AssetFileDescriptor openRawResourceFd(int i7) {
        return super.openRawResourceFd(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i7) {
        Context context = (Context) this.f21340b.get();
        return context != null ? J.g().r(context, this, i7) : a(i7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i7, int i8, Resources.Theme theme) {
        return super.getDrawableForDensity(i7, i8, theme);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getQuantityString(int i7, int i8, Object[] objArr) {
        return super.getQuantityString(i7, i8, objArr);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getString(int i7, Object[] objArr) {
        return super.getString(i7, objArr);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getText(int i7, CharSequence charSequence) {
        return super.getText(i7, charSequence);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(String str, TypedValue typedValue, boolean z7) {
        super.getValue(str, typedValue, z7);
    }

    @Override // p.K, android.content.res.Resources
    public /* bridge */ /* synthetic */ InputStream openRawResource(int i7, TypedValue typedValue) {
        return super.openRawResource(i7, typedValue);
    }
}
