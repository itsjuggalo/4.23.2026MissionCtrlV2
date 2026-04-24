package o;

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
public class V extends F {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f21801c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f21802b;

    public V(Context context, Resources resources) {
        super(resources);
        this.f21802b = new WeakReference(context);
    }

    public static boolean b() {
        return f21801c;
    }

    public static boolean c() {
        b();
        return false;
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getAnimation(int i8) {
        return super.getAnimation(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ boolean getBoolean(int i8) {
        return super.getBoolean(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getColor(int i8) {
        return super.getColor(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ ColorStateList getColorStateList(int i8) {
        return super.getColorStateList(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ Configuration getConfiguration() {
        return super.getConfiguration();
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ float getDimension(int i8) {
        return super.getDimension(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getDimensionPixelOffset(int i8) {
        return super.getDimensionPixelOffset(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getDimensionPixelSize(int i8) {
        return super.getDimensionPixelSize(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ DisplayMetrics getDisplayMetrics() {
        return super.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i8) {
        Context context = (Context) this.f21802b.get();
        return context != null ? E.g().r(context, this, i8) : a(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i8, int i9) {
        return super.getDrawableForDensity(i8, i9);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ float getFraction(int i8, int i9, int i10) {
        return super.getFraction(i8, i9, i10);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getIdentifier(String str, String str2, String str3) {
        return super.getIdentifier(str, str2, str3);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ int[] getIntArray(int i8) {
        return super.getIntArray(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ int getInteger(int i8) {
        return super.getInteger(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getLayout(int i8) {
        return super.getLayout(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ Movie getMovie(int i8) {
        return super.getMovie(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getQuantityString(int i8, int i9) {
        return super.getQuantityString(i8, i9);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getQuantityText(int i8, int i9) {
        return super.getQuantityText(i8, i9);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceEntryName(int i8) {
        return super.getResourceEntryName(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceName(int i8) {
        return super.getResourceName(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourcePackageName(int i8) {
        return super.getResourcePackageName(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getResourceTypeName(int i8) {
        return super.getResourceTypeName(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getString(int i8) {
        return super.getString(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String[] getStringArray(int i8) {
        return super.getStringArray(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getText(int i8) {
        return super.getText(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence[] getTextArray(int i8) {
        return super.getTextArray(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(int i8, TypedValue typedValue, boolean z7) {
        super.getValue(i8, typedValue, z7);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValueForDensity(int i8, int i9, TypedValue typedValue, boolean z7) {
        super.getValueForDensity(i8, i9, typedValue, z7);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ XmlResourceParser getXml(int i8) {
        return super.getXml(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return super.obtainAttributes(attributeSet, iArr);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ TypedArray obtainTypedArray(int i8) {
        return super.obtainTypedArray(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ InputStream openRawResource(int i8) {
        return super.openRawResource(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ AssetFileDescriptor openRawResourceFd(int i8) {
        return super.openRawResourceFd(i8);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        super.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        super.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawable(int i8, Resources.Theme theme) {
        return super.getDrawable(i8, theme);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ Drawable getDrawableForDensity(int i8, int i9, Resources.Theme theme) {
        return super.getDrawableForDensity(i8, i9, theme);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getQuantityString(int i8, int i9, Object[] objArr) {
        return super.getQuantityString(i8, i9, objArr);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ String getString(int i8, Object[] objArr) {
        return super.getString(i8, objArr);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ CharSequence getText(int i8, CharSequence charSequence) {
        return super.getText(i8, charSequence);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ void getValue(String str, TypedValue typedValue, boolean z7) {
        super.getValue(str, typedValue, z7);
    }

    @Override // o.F, android.content.res.Resources
    public /* bridge */ /* synthetic */ InputStream openRawResource(int i8, TypedValue typedValue) {
        return super.openRawResource(i8, typedValue);
    }
}
