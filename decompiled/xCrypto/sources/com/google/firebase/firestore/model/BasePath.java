package com.google.firebase.firestore.model;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BasePath<B extends BasePath<B>> implements Comparable<B> {
    final List<String> segments;

    public BasePath(List<String> list) {
        this.segments = list;
    }

    private static int compareSegments(String str, String str2) {
        boolean zIsNumericId = isNumericId(str);
        boolean zIsNumericId2 = isNumericId(str2);
        if (zIsNumericId && !zIsNumericId2) {
            return -1;
        }
        if (zIsNumericId || !zIsNumericId2) {
            return (zIsNumericId && zIsNumericId2) ? Long.compare(extractNumericId(str), extractNumericId(str2)) : Util.compareUtf8Strings(str, str2);
        }
        return 1;
    }

    private static long extractNumericId(String str) {
        return Long.parseLong(str.substring(4, str.length() - 2));
    }

    private static boolean isNumericId(String str) {
        return str.startsWith("__id") && str.endsWith("__");
    }

    public B append(String str) {
        ArrayList arrayList = new ArrayList(this.segments);
        arrayList.add(str);
        return (B) createPathWithSegments(arrayList);
    }

    public abstract String canonicalString();

    public abstract B createPathWithSegments(List<String> list);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BasePath) && compareTo((BasePath) obj) == 0;
    }

    public String getFirstSegment() {
        return this.segments.get(0);
    }

    public String getLastSegment() {
        return this.segments.get(length() - 1);
    }

    public String getSegment(int i4) {
        return this.segments.get(i4);
    }

    public int hashCode() {
        return ((getClass().hashCode() + 37) * 37) + this.segments.hashCode();
    }

    public boolean isEmpty() {
        return length() == 0;
    }

    public boolean isImmediateParentOf(B b4) {
        if (length() + 1 != b4.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length(); i4++) {
            if (!getSegment(i4).equals(b4.getSegment(i4))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrefixOf(B b4) {
        if (length() > b4.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length(); i4++) {
            if (!getSegment(i4).equals(b4.getSegment(i4))) {
                return false;
            }
        }
        return true;
    }

    public B keepFirst(int i4) {
        return (B) createPathWithSegments(this.segments.subList(0, i4));
    }

    public int length() {
        return this.segments.size();
    }

    public B popFirst() {
        return (B) popFirst(1);
    }

    public B popLast() {
        return (B) createPathWithSegments(this.segments.subList(0, length() - 1));
    }

    public String toString() {
        return canonicalString();
    }

    @Override // java.lang.Comparable
    public int compareTo(B b4) {
        int length = length();
        int length2 = b4.length();
        for (int i4 = 0; i4 < length && i4 < length2; i4++) {
            int iCompareSegments = compareSegments(getSegment(i4), b4.getSegment(i4));
            if (iCompareSegments != 0) {
                return iCompareSegments;
            }
        }
        return Util.compareIntegers(length, length2);
    }

    public B popFirst(int i4) {
        int length = length();
        Assert.hardAssert(length >= i4, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(i4), Integer.valueOf(length));
        return (B) createPathWithSegments(this.segments.subList(i4, length));
    }

    public B append(B b4) {
        ArrayList arrayList = new ArrayList(this.segments);
        arrayList.addAll(b4.segments);
        return (B) createPathWithSegments(arrayList);
    }
}
