package com.google.firebase.firestore.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FieldPath extends BasePath<FieldPath> {
    public static final FieldPath KEY_PATH = fromSingleSegment(DocumentKey.KEY_FIELD_NAME);
    public static final FieldPath EMPTY_PATH = new FieldPath(Collections.EMPTY_LIST);

    private FieldPath(List<String> list) {
        super(list);
    }

    public static FieldPath fromSegments(List<String> list) {
        return list.isEmpty() ? EMPTY_PATH : new FieldPath(list);
    }

    public static FieldPath fromServerFormat(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        boolean z4 = false;
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '\\') {
                i4++;
                if (i4 == str.length()) {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
                sb.append(str.charAt(i4));
            } else if (cCharAt == '.') {
                if (z4) {
                    sb.append(cCharAt);
                } else {
                    String string = sb.toString();
                    if (string.isEmpty()) {
                        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
                    }
                    StringBuilder sb2 = new StringBuilder();
                    arrayList.add(string);
                    sb = sb2;
                }
            } else if (cCharAt == '`') {
                z4 = !z4;
            } else {
                sb.append(cCharAt);
            }
            i4++;
        }
        String string2 = sb.toString();
        if (!string2.isEmpty()) {
            arrayList.add(string2);
            return new FieldPath(arrayList);
        }
        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }

    public static FieldPath fromSingleSegment(String str) {
        return new FieldPath(Collections.singletonList(str));
    }

    private static boolean isValidIdentifier(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '_' && ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z'))) {
            return false;
        }
        for (int i4 = 1; i4 < str.length(); i4++) {
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 != '_' && ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && (cCharAt2 < '0' || cCharAt2 > '9')))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public String canonicalString() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.segments.size(); i4++) {
            if (i4 > 0) {
                sb.append(".");
            }
            String strReplace = this.segments.get(i4).replace("\\", "\\\\").replace("`", "\\`");
            if (!isValidIdentifier(strReplace)) {
                strReplace = '`' + strReplace + '`';
            }
            sb.append(strReplace);
        }
        return sb.toString();
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public /* bridge */ /* synthetic */ BasePath createPathWithSegments(List list) {
        return createPathWithSegments((List<String>) list);
    }

    public boolean isKeyField() {
        return equals(KEY_PATH);
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public FieldPath createPathWithSegments(List<String> list) {
        return new FieldPath(list);
    }
}
