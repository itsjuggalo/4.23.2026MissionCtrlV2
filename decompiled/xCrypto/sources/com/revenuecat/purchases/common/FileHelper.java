package com.revenuecat.purchases.common;

import W2.E;
import android.content.Context;
import com.revenuecat.purchases.utils.FileExtensionsKt;
import g3.m;
import i3.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import q3.e;
import q3.l;
import r3.C1756c;

/* JADX INFO: loaded from: classes.dex */
public final class FileHelper {
    private final Context applicationContext;

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.FileHelper$readFilePerLines$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ k $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar) {
            super(1);
            this.$block = kVar;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BufferedReader) obj);
            return E.f5463a;
        }

        public final void invoke(BufferedReader bufferedReader) {
            r.f(bufferedReader, "bufferedReader");
            this.$block.invoke(m.c(bufferedReader));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.FileHelper$removeFirstLinesFromFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11391 extends s implements k {
        final /* synthetic */ int $numberOfLinesToRemove;
        final /* synthetic */ StringBuilder $textToAppend;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11391(int i4, StringBuilder sb) {
            super(1);
            this.$numberOfLinesToRemove = i4;
            this.$textToAppend = sb;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((e) obj);
            return E.f5463a;
        }

        public final void invoke(e sequence) {
            r.f(sequence, "sequence");
            e eVarH = l.h(sequence, this.$numberOfLinesToRemove);
            StringBuilder sb = this.$textToAppend;
            Iterator it = eVarH.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append("\n");
            }
        }
    }

    public FileHelper(Context applicationContext) {
        r.f(applicationContext, "applicationContext");
        this.applicationContext = applicationContext;
    }

    private final File getFileInFilesDir(String str) {
        return new File(getFilesDir(), str);
    }

    private final File getFilesDir() {
        File filesDir = this.applicationContext.getFilesDir();
        r.e(filesDir, "applicationContext.filesDir");
        return filesDir;
    }

    private final void openBufferedReader(String str, k kVar) throws IllegalAccessException, IOException, InvocationTargetException {
        FileInputStream fileInputStream = new FileInputStream(getFileInFilesDir(str));
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    kVar.invoke(bufferedReader);
                    E e4 = E.f5463a;
                    g3.b.a(bufferedReader, null);
                    g3.b.a(inputStreamReader, null);
                    g3.b.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public final void appendToFile(String filePath, String contentToAppend) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(filePath, "filePath");
        r.f(contentToAppend, "contentToAppend");
        File fileInFilesDir = getFileInFilesDir(filePath);
        File parentFile = fileInFilesDir.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileInFilesDir, true);
        try {
            byte[] bytes = contentToAppend.getBytes(C1756c.f14563b);
            r.e(bytes, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            E e4 = E.f5463a;
            g3.b.a(fileOutputStream, null);
        } finally {
        }
    }

    public final boolean deleteFile(String filePath) {
        r.f(filePath, "filePath");
        return getFileInFilesDir(filePath).delete();
    }

    public final boolean fileIsEmpty(String filePath) {
        r.f(filePath, "filePath");
        File fileInFilesDir = getFileInFilesDir(filePath);
        return !fileInFilesDir.exists() || fileInFilesDir.length() == 0;
    }

    public final double fileSizeInKB(String filePath) {
        r.f(filePath, "filePath");
        return FileExtensionsKt.getSizeInKB(getFileInFilesDir(filePath));
    }

    public final void readFilePerLines(String filePath, k block) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(filePath, "filePath");
        r.f(block, "block");
        openBufferedReader(filePath, new AnonymousClass1(block));
    }

    public final void removeFirstLinesFromFile(String filePath, int i4) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(filePath, "filePath");
        StringBuilder sb = new StringBuilder();
        readFilePerLines(filePath, new C11391(i4, sb));
        deleteFile(filePath);
        String string = sb.toString();
        r.e(string, "textToAppend.toString()");
        appendToFile(filePath, string);
    }
}
