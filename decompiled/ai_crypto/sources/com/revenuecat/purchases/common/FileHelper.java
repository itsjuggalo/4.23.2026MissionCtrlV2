package com.revenuecat.purchases.common;

import E5.E;
import O5.m;
import Q5.k;
import Y5.f;
import Z5.C0796c;
import android.content.Context;
import com.revenuecat.purchases.utils.FileExtensionsKt;
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

/* JADX INFO: loaded from: classes2.dex */
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

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BufferedReader) obj);
            return E.f1657a;
        }

        public final void invoke(BufferedReader bufferedReader) {
            r.f(bufferedReader, "bufferedReader");
            this.$block.invoke(m.c(bufferedReader));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.FileHelper$removeFirstLinesFromFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C13131 extends s implements k {
        final /* synthetic */ int $numberOfLinesToRemove;
        final /* synthetic */ StringBuilder $textToAppend;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C13131(int i7, StringBuilder sb) {
            super(1);
            this.$numberOfLinesToRemove = i7;
            this.$textToAppend = sb;
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((f) obj);
            return E.f1657a;
        }

        public final void invoke(f sequence) {
            r.f(sequence, "sequence");
            f fVarI = Y5.m.i(sequence, this.$numberOfLinesToRemove);
            StringBuilder sb = this.$textToAppend;
            Iterator it = fVarI.iterator();
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
                    E e7 = E.f1657a;
                    O5.b.a(bufferedReader, null);
                    O5.b.a(inputStreamReader, null);
                    O5.b.a(fileInputStream, null);
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
            byte[] bytes = contentToAppend.getBytes(C0796c.f6018b);
            r.e(bytes, "this as java.lang.String).getBytes(charset)");
            fileOutputStream.write(bytes);
            E e7 = E.f1657a;
            O5.b.a(fileOutputStream, null);
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

    public final void removeFirstLinesFromFile(String filePath, int i7) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(filePath, "filePath");
        StringBuilder sb = new StringBuilder();
        readFilePerLines(filePath, new C13131(i7, sb));
        deleteFile(filePath);
        String string = sb.toString();
        r.e(string, "textToAppend.toString()");
        appendToFile(filePath, string);
    }
}
