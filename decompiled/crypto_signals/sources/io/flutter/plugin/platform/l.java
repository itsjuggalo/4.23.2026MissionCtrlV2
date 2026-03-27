package io.flutter.plugin.platform;

import K2.C0061l;
import P3.AbstractActivityC0229d;
import P3.C;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import s4.C1057d;

/* JADX INFO: loaded from: classes.dex */
public final class l implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7163b;

    public /* synthetic */ l(Object obj, int i) {
        this.f7162a = i;
        this.f7163b = obj;
    }

    @Override // io.flutter.plugin.platform.g
    public void a(int i, int i6) {
        ((TextureRegistry$SurfaceProducer) this.f7163b).setSize(i, i6);
    }

    @Override // io.flutter.plugin.platform.g
    public long b() {
        return ((TextureRegistry$SurfaceProducer) this.f7163b).id();
    }

    public void c(int i) {
        View view;
        switch (this.f7162a) {
            case 0:
                o oVar = (o) this.f7163b;
                if (oVar.n(i)) {
                    view = ((z) oVar.f7186j.get(Integer.valueOf(i))).a();
                } else {
                    f fVar = (f) oVar.f7188l.get(i);
                    if (fVar == null) {
                        Log.e("PlatformViewsController", "Clearing focus on an unknown view with id: " + i);
                    } else {
                        view = fVar.getView();
                    }
                }
                if (view != null) {
                    view.clearFocus();
                } else {
                    Log.e("PlatformViewsController", "Clearing focus on a null view with id: " + i);
                }
                break;
            default:
                f fVar2 = (f) ((n) this.f7163b).i.get(i);
                if (fVar2 != null) {
                    View view2 = fVar2.getView();
                    if (view2 != null) {
                        view2.clearFocus();
                    } else {
                        Log.e("PlatformViewsController2", "Clearing focus on a null view with id: " + i);
                    }
                } else {
                    Log.e("PlatformViewsController2", "Clearing focus on an unknown view with id: " + i);
                }
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [io.flutter.plugin.platform.j] */
    public long d(final Y3.e eVar) {
        h hVar;
        long j4;
        final int i = 0;
        final int i6 = 1;
        final o oVar = (o) this.f7163b;
        o.a(oVar, eVar);
        SparseArray sparseArray = oVar.f7191o;
        int i7 = eVar.f3631a;
        if (sparseArray.get(i7) != null) {
            throw new IllegalStateException(a3.d.f(i7, "Trying to create an already created platform view, view id: "));
        }
        if (oVar.f7183f == null) {
            throw new IllegalStateException(a3.d.f(i7, "Texture registry is null. This means that platform views controller was detached, view id: "));
        }
        if (oVar.f7182d == null) {
            throw new IllegalStateException(a3.d.f(i7, "Flutter view is null. This means the platform views controller doesn't have an attached view, view id: "));
        }
        f fVarB = oVar.b(eVar, true);
        View view = fVarB.getView();
        if (view.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        boolean zV = y5.a.V(view, new C1057d(o.f7178x, 5));
        double d4 = eVar.f3634d;
        double d6 = eVar.f3633c;
        if (zV) {
            if (eVar.f3637h == 2) {
                o.e(19);
                if (oVar.e.IsSurfaceControlEnabled()) {
                    throw new IllegalStateException("Trying to create a Hybrid Composition view with HC++ enabled.");
                }
                return -2L;
            }
            if (!oVar.f7198v) {
                o.e(20);
                g gVarJ = o.j(oVar.f7183f);
                int iM = oVar.m(d6);
                int iM2 = oVar.m(d4);
                Activity activity = oVar.f7181c;
                ?? r7 = new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.j
                    @Override // android.view.View.OnFocusChangeListener
                    public final void onFocusChange(View view2, boolean z6) {
                        switch (i6) {
                            case 0:
                                Y3.e eVar2 = eVar;
                                o oVar2 = oVar;
                                int i8 = eVar2.f3631a;
                                if (!z6) {
                                    io.flutter.plugin.editing.i iVar = oVar2.f7184g;
                                    if (iVar != null) {
                                        iVar.b(i8);
                                    }
                                    break;
                                } else {
                                    Z3.q qVar = (Z3.q) oVar2.f7185h.f3629b;
                                    if (qVar != null) {
                                        qVar.a("viewFocused", Integer.valueOf(i8), null);
                                        break;
                                    }
                                }
                                break;
                            default:
                                o oVar3 = oVar;
                                if (!z6) {
                                    oVar3.getClass();
                                    break;
                                } else {
                                    Y3.d dVar = oVar3.f7185h;
                                    Y3.e eVar3 = eVar;
                                    Z3.q qVar2 = (Z3.q) dVar.f3629b;
                                    if (qVar2 != null) {
                                        qVar2.a("viewFocused", Integer.valueOf(eVar3.f3631a), null);
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                };
                w wVar = z.i;
                z zVar = null;
                if (iM != 0 && iM2 != 0) {
                    DisplayManager displayManager = (DisplayManager) activity.getSystemService("display");
                    DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
                    gVarJ.a(iM, iM2);
                    StringBuilder sb = new StringBuilder("flutter-vd#");
                    int i8 = eVar.f3631a;
                    sb.append(i8);
                    VirtualDisplay virtualDisplayCreateVirtualDisplay = displayManager.createVirtualDisplay(sb.toString(), iM, iM2, displayMetrics.densityDpi, gVarJ.getSurface(), 0, z.i, null);
                    if (virtualDisplayCreateVirtualDisplay != null) {
                        zVar = new z(activity, oVar.i, virtualDisplayCreateVirtualDisplay, fVarB, gVarJ, r7, i8);
                    }
                }
                if (zVar != null) {
                    oVar.f7186j.put(Integer.valueOf(i7), zVar);
                    View view2 = fVarB.getView();
                    oVar.f7187k.put(view2.getContext(), view2);
                    return gVarJ.b();
                }
                throw new IllegalStateException("Failed creating virtual display for a " + eVar.f3632b + " with id: " + i7);
            }
        }
        o.e(23);
        int iM3 = oVar.m(d6);
        int iM4 = oVar.m(d4);
        if (oVar.f7198v) {
            hVar = new h(oVar.f7181c);
            j4 = -1;
        } else {
            g gVarJ2 = o.j(oVar.f7183f);
            h hVar2 = new h(oVar.f7181c);
            hVar2.f7150f = gVarJ2;
            Surface surface = gVarJ2.getSurface();
            if (surface != null) {
                Canvas canvasLockHardwareCanvas = surface.lockHardwareCanvas();
                try {
                    canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                } finally {
                    surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
                }
            }
            long jB = gVarJ2.b();
            hVar = hVar2;
            j4 = jB;
        }
        hVar.setTouchProcessor(oVar.f7180b);
        g gVar = hVar.f7150f;
        if (gVar != null) {
            gVar.a(iM3, iM4);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iM3, iM4);
        int iM5 = oVar.m(eVar.e);
        int iM6 = oVar.m(eVar.f3635f);
        layoutParams.topMargin = iM5;
        layoutParams.leftMargin = iM6;
        hVar.setLayoutParams(layoutParams);
        View view3 = fVarB.getView();
        view3.setLayoutParams(new FrameLayout.LayoutParams(iM3, iM4));
        view3.setImportantForAccessibility(4);
        hVar.addView(view3);
        hVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.j
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view22, boolean z6) {
                switch (i) {
                    case 0:
                        Y3.e eVar2 = eVar;
                        o oVar2 = oVar;
                        int i82 = eVar2.f3631a;
                        if (!z6) {
                            io.flutter.plugin.editing.i iVar = oVar2.f7184g;
                            if (iVar != null) {
                                iVar.b(i82);
                            }
                            break;
                        } else {
                            Z3.q qVar = (Z3.q) oVar2.f7185h.f3629b;
                            if (qVar != null) {
                                qVar.a("viewFocused", Integer.valueOf(i82), null);
                                break;
                            }
                        }
                        break;
                    default:
                        o oVar3 = oVar;
                        if (!z6) {
                            oVar3.getClass();
                            break;
                        } else {
                            Y3.d dVar = oVar3.f7185h;
                            Y3.e eVar3 = eVar;
                            Z3.q qVar2 = (Z3.q) dVar.f3629b;
                            if (qVar2 != null) {
                                qVar2.a("viewFocused", Integer.valueOf(eVar3.f3631a), null);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        oVar.f7182d.addView(hVar);
        sparseArray.append(i7, hVar);
        return j4;
    }

    public void e(int i) {
        U3.a aVar;
        switch (this.f7162a) {
            case 0:
                o oVar = (o) this.f7163b;
                f fVar = (f) oVar.f7188l.get(i);
                if (fVar != null) {
                    if (fVar.getView() != null) {
                        View view = fVar.getView();
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(view);
                        }
                    }
                    oVar.f7188l.remove(i);
                    if (!oVar.n(i)) {
                        SparseArray sparseArray = oVar.f7191o;
                        h hVar = (h) sparseArray.get(i);
                        if (hVar == null) {
                            SparseArray sparseArray2 = oVar.f7189m;
                            U3.b bVar = (U3.b) sparseArray2.get(i);
                            if (bVar != null) {
                                bVar.removeAllViews();
                                bVar.a();
                                ViewGroup viewGroup2 = (ViewGroup) bVar.getParent();
                                if (viewGroup2 != null) {
                                    viewGroup2.removeView(bVar);
                                }
                                sparseArray2.remove(i);
                            }
                        } else {
                            hVar.removeAllViews();
                            g gVar = hVar.f7150f;
                            if (gVar != null) {
                                gVar.release();
                                hVar.f7150f = null;
                            }
                            ViewTreeObserver viewTreeObserver = hVar.getViewTreeObserver();
                            if (viewTreeObserver.isAlive() && (aVar = hVar.f7151k) != null) {
                                hVar.f7151k = null;
                                viewTreeObserver.removeOnGlobalFocusChangeListener(aVar);
                            }
                            ViewGroup viewGroup3 = (ViewGroup) hVar.getParent();
                            if (viewGroup3 != null) {
                                viewGroup3.removeView(hVar);
                            }
                            sparseArray.remove(i);
                        }
                    } else {
                        HashMap map = oVar.f7186j;
                        z zVar = (z) map.get(Integer.valueOf(i));
                        View viewA = zVar.a();
                        if (viewA != null) {
                            oVar.f7187k.remove(viewA.getContext());
                        }
                        zVar.f7219a.cancel();
                        zVar.f7219a.detachState();
                        zVar.f7225h.release();
                        zVar.f7223f.release();
                        map.remove(Integer.valueOf(i));
                    }
                } else {
                    Log.e("PlatformViewsController", "Disposing unknown platform view with id: " + i);
                }
                break;
            default:
                n nVar = (n) this.f7163b;
                f fVar2 = (f) nVar.i.get(i);
                if (fVar2 != null) {
                    if (fVar2.getView() != null) {
                        View view2 = fVar2.getView();
                        ViewGroup viewGroup4 = (ViewGroup) view2.getParent();
                        if (viewGroup4 != null) {
                            viewGroup4.removeView(view2);
                        }
                    }
                    nVar.i.remove(i);
                    SparseArray sparseArray3 = nVar.f7171j;
                    U3.b bVar2 = (U3.b) sparseArray3.get(i);
                    if (bVar2 != null) {
                        bVar2.removeAllViews();
                        bVar2.a();
                        ViewGroup viewGroup5 = (ViewGroup) bVar2.getParent();
                        if (viewGroup5 != null) {
                            viewGroup5.removeView(bVar2);
                        }
                        sparseArray3.remove(i);
                    }
                } else {
                    Log.e("PlatformViewsController2", "Disposing unknown platform view with id: " + i);
                }
                break;
        }
    }

    public CharSequence f(Y3.b bVar) {
        AbstractActivityC0229d abstractActivityC0229d = (AbstractActivityC0229d) ((com.google.firebase.storage.z) this.f7163b).f5630c;
        ClipboardManager clipboardManager = (ClipboardManager) abstractActivityC0229d.getSystemService("clipboard");
        CharSequence charSequence = null;
        if (clipboardManager.hasPrimaryClip()) {
            try {
                try {
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    if (primaryClip != null) {
                        if (bVar != null) {
                            if (bVar == Y3.b.f3621a) {
                            }
                        }
                        ClipData.Item itemAt = primaryClip.getItemAt(0);
                        CharSequence text = itemAt.getText();
                        if (text != null) {
                            return text;
                        }
                        try {
                            Uri uri = itemAt.getUri();
                            if (uri == null) {
                                Log.w("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                                return null;
                            }
                            String scheme = uri.getScheme();
                            if (!scheme.equals("content")) {
                                Log.w("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                                return null;
                            }
                            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = abstractActivityC0229d.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                            CharSequence charSequenceCoerceToText = itemAt.coerceToText(abstractActivityC0229d);
                            if (assetFileDescriptorOpenTypedAssetFileDescriptor == null) {
                                return charSequenceCoerceToText;
                            }
                            try {
                                assetFileDescriptorOpenTypedAssetFileDescriptor.close();
                                return charSequenceCoerceToText;
                            } catch (IOException e) {
                                charSequence = charSequenceCoerceToText;
                                e = e;
                                Log.w("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
                                return charSequence;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            charSequence = text;
                        }
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (FileNotFoundException unused) {
                Log.w("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
                return charSequence;
            } catch (SecurityException e7) {
                Log.w("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e7);
                return charSequence;
            }
        }
        return null;
    }

    public void g(int i, double d4, double d6) {
        o oVar = (o) this.f7163b;
        if (oVar.n(i)) {
            return;
        }
        h hVar = (h) oVar.f7191o.get(i);
        if (hVar == null) {
            Log.e("PlatformViewsController", "Setting offset for unknown platform view with id: " + i);
        } else {
            int iM = oVar.m(d4);
            int iM2 = oVar.m(d6);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) hVar.getLayoutParams();
            layoutParams.topMargin = iM;
            layoutParams.leftMargin = iM2;
            hVar.setLayoutParams(layoutParams);
        }
    }

    @Override // io.flutter.plugin.platform.g
    public int getHeight() {
        return ((TextureRegistry$SurfaceProducer) this.f7163b).getHeight();
    }

    @Override // io.flutter.plugin.platform.g
    public Surface getSurface() {
        return ((TextureRegistry$SurfaceProducer) this.f7163b).getSurface();
    }

    @Override // io.flutter.plugin.platform.g
    public int getWidth() {
        return ((TextureRegistry$SurfaceProducer) this.f7163b).getWidth();
    }

    public void h(Y3.g gVar) {
        o oVar = (o) this.f7163b;
        float f6 = oVar.f7181c.getResources().getDisplayMetrics().density;
        int i = gVar.f3641a;
        if (oVar.n(i)) {
            z zVar = (z) oVar.f7186j.get(Integer.valueOf(i));
            MotionEvent motionEventL = oVar.l(f6, gVar, true);
            SingleViewPresentation singleViewPresentation = zVar.f7219a;
            if (singleViewPresentation == null) {
                return;
            }
            singleViewPresentation.dispatchTouchEvent(motionEventL);
            return;
        }
        f fVar = (f) oVar.f7188l.get(i);
        if (fVar == null) {
            Log.e("PlatformViewsController", "Sending touch to an unknown view with id: " + i);
            return;
        }
        View view = fVar.getView();
        if (view != null) {
            view.dispatchTouchEvent(oVar.l(f6, gVar, false));
            return;
        }
        Log.e("PlatformViewsController", "Sending touch to a null view with id: " + i);
    }

    public void i(Y3.g gVar) {
        n nVar = (n) this.f7163b;
        float f6 = nVar.f7166c.getResources().getDisplayMetrics().density;
        SparseArray sparseArray = nVar.i;
        int i = gVar.f3641a;
        f fVar = (f) sparseArray.get(i);
        if (fVar == null) {
            Log.e("PlatformViewsController2", "Sending touch to an unknown view with id: " + i);
            return;
        }
        View view = fVar.getView();
        if (view == null) {
            Log.e("PlatformViewsController2", "Sending touch to a null view with id: " + i);
            return;
        }
        MotionEvent motionEventO = nVar.f7172k.O(new C(gVar.f3654p));
        List<List> list = (List) gVar.f3646g;
        ArrayList arrayList = new ArrayList();
        for (List list2 : list) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.orientation = (float) ((Double) list2.get(0)).doubleValue();
            pointerCoords.pressure = (float) ((Double) list2.get(1)).doubleValue();
            pointerCoords.size = (float) ((Double) list2.get(2)).doubleValue();
            double d4 = f6;
            pointerCoords.toolMajor = (float) (((Double) list2.get(3)).doubleValue() * d4);
            pointerCoords.toolMinor = (float) (((Double) list2.get(4)).doubleValue() * d4);
            pointerCoords.touchMajor = (float) (((Double) list2.get(5)).doubleValue() * d4);
            pointerCoords.touchMinor = (float) (((Double) list2.get(6)).doubleValue() * d4);
            pointerCoords.x = (float) (((Double) list2.get(7)).doubleValue() * d4);
            pointerCoords.y = (float) (((Double) list2.get(8)).doubleValue() * d4);
            arrayList.add(pointerCoords);
        }
        int i6 = gVar.e;
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) arrayList.toArray(new MotionEvent.PointerCoords[i6]);
        if (motionEventO == null) {
            List<List> list3 = (List) gVar.f3645f;
            ArrayList arrayList2 = new ArrayList();
            for (List list4 : list3) {
                MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                pointerProperties.id = ((Integer) list4.get(0)).intValue();
                pointerProperties.toolType = ((Integer) list4.get(1)).intValue();
                arrayList2.add(pointerProperties);
            }
            motionEventO = MotionEvent.obtain(gVar.f3642b.longValue(), gVar.f3643c.longValue(), gVar.f3644d, gVar.e, (MotionEvent.PointerProperties[]) arrayList2.toArray(new MotionEvent.PointerProperties[i6]), pointerCoordsArr, gVar.f3647h, gVar.i, gVar.f3648j, gVar.f3649k, gVar.f3650l, gVar.f3651m, gVar.f3652n, gVar.f3653o);
        } else if (pointerCoordsArr.length >= 1) {
            motionEventO.offsetLocation(pointerCoordsArr[0].x - motionEventO.getX(), pointerCoordsArr[0].y - motionEventO.getY());
        }
        view.dispatchTouchEvent(motionEventO);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [io.flutter.plugin.platform.k, java.lang.Runnable] */
    public void j(Y3.f fVar, final C0061l c0061l) {
        g gVar;
        o oVar = (o) this.f7163b;
        int iM = oVar.m(fVar.f3639b);
        int iM2 = oVar.m(fVar.f3640c);
        int i = fVar.f3638a;
        if (!oVar.n(i)) {
            f fVar2 = (f) oVar.f7188l.get(i);
            h hVar = (h) oVar.f7191o.get(i);
            if (fVar2 == null || hVar == null) {
                Log.e("PlatformViewsController", "Resizing unknown platform view with id: " + i);
                return;
            }
            if ((iM > hVar.getRenderTargetWidth() || iM2 > hVar.getRenderTargetHeight()) && (gVar = hVar.f7150f) != null) {
                gVar.a(iM, iM2);
            }
            ViewGroup.LayoutParams layoutParams = hVar.getLayoutParams();
            layoutParams.width = iM;
            layoutParams.height = iM2;
            hVar.setLayoutParams(layoutParams);
            View view = fVar2.getView();
            if (view != null) {
                ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                layoutParams2.width = iM;
                layoutParams2.height = iM2;
                view.setLayoutParams(layoutParams2);
            }
            int iRound = (int) Math.round(((double) hVar.getRenderTargetWidth()) / ((double) oVar.g()));
            int iRound2 = (int) Math.round(((double) hVar.getRenderTargetHeight()) / ((double) oVar.g()));
            Y3.h hVar2 = (Y3.h) c0061l.f944b;
            HashMap map = new HashMap();
            map.put("width", Double.valueOf(iRound));
            map.put("height", Double.valueOf(iRound2));
            hVar2.c(map);
            return;
        }
        final float fG = oVar.g();
        final z zVar = (z) oVar.f7186j.get(Integer.valueOf(i));
        io.flutter.plugin.editing.i iVar = oVar.f7184g;
        if (iVar != null) {
            if (iVar.e.f240b == 3) {
                iVar.f7133p = true;
            }
            SingleViewPresentation singleViewPresentation = zVar.f7219a;
            if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
                zVar.f7219a.getView().getClass();
            }
        }
        ?? r32 = new Runnable() { // from class: io.flutter.plugin.platform.k
            @Override // java.lang.Runnable
            public final void run() {
                o oVar2 = (o) this.f7158a.f7163b;
                io.flutter.plugin.editing.i iVar2 = oVar2.f7184g;
                z zVar2 = zVar;
                if (iVar2 != null) {
                    if (iVar2.e.f240b == 3) {
                        iVar2.f7133p = false;
                    }
                    SingleViewPresentation singleViewPresentation2 = zVar2.f7219a;
                    if (singleViewPresentation2 != null && singleViewPresentation2.getView() != null) {
                        zVar2.f7219a.getView().getClass();
                    }
                }
                double dG = oVar2.f7181c == null ? fG : oVar2.g();
                int iRound3 = (int) Math.round(((double) zVar2.f7223f.getWidth()) / dG);
                int iRound4 = (int) Math.round(((double) zVar2.f7223f.getHeight()) / dG);
                Y3.h hVar3 = (Y3.h) c0061l.f944b;
                HashMap map2 = new HashMap();
                map2.put("width", Double.valueOf(iRound3));
                map2.put("height", Double.valueOf(iRound4));
                hVar3.c(map2);
            }
        };
        int width = zVar.f7223f.getWidth();
        g gVar2 = zVar.f7223f;
        if (iM == width && iM2 == gVar2.getHeight()) {
            zVar.a().postDelayed(r32, 0L);
            return;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            View viewA = zVar.a();
            gVar2.a(iM, iM2);
            zVar.f7225h.resize(iM, iM2, zVar.f7222d);
            zVar.f7225h.setSurface(gVar2.getSurface());
            viewA.postDelayed(r32, 0L);
            return;
        }
        boolean zIsFocused = zVar.a().isFocused();
        u uVarDetachState = zVar.f7219a.detachState();
        zVar.f7225h.setSurface(null);
        zVar.f7225h.release();
        DisplayManager displayManager = (DisplayManager) zVar.f7220b.getSystemService("display");
        gVar2.a(iM, iM2);
        zVar.f7225h = displayManager.createVirtualDisplay("flutter-vd#" + zVar.e, iM, iM2, zVar.f7222d, gVar2.getSurface(), 0, z.i, null);
        View viewA2 = zVar.a();
        viewA2.addOnAttachStateChangeListener(new E0.i(viewA2, (k) r32));
        SingleViewPresentation singleViewPresentation2 = new SingleViewPresentation(zVar.f7220b, zVar.f7225h.getDisplay(), zVar.f7221c, uVarDetachState, zVar.f7224g, zIsFocused);
        singleViewPresentation2.show();
        zVar.f7219a.cancel();
        zVar.f7219a = singleViewPresentation2;
    }

    public void k(int i, int i6) {
        View view;
        switch (this.f7162a) {
            case 0:
                if (i6 != 0 && i6 != 1) {
                    throw new IllegalStateException("Trying to set unknown direction value: " + i6 + "(view id: " + i + ")");
                }
                o oVar = (o) this.f7163b;
                if (oVar.n(i)) {
                    view = ((z) oVar.f7186j.get(Integer.valueOf(i))).a();
                } else {
                    f fVar = (f) oVar.f7188l.get(i);
                    if (fVar == null) {
                        Log.e("PlatformViewsController", "Setting direction to an unknown view with id: " + i);
                        return;
                    }
                    view = fVar.getView();
                }
                if (view != null) {
                    view.setLayoutDirection(i6);
                    return;
                }
                Log.e("PlatformViewsController", "Setting direction to a null view with id: " + i);
                return;
            default:
                f fVar2 = (f) ((n) this.f7163b).i.get(i);
                if (fVar2 == null) {
                    Log.e("PlatformViewsController2", "Setting direction to an unknown view with id: " + i);
                    return;
                }
                View view2 = fVar2.getView();
                if (view2 != null) {
                    view2.setLayoutDirection(i6);
                    return;
                }
                Log.e("PlatformViewsController2", "Setting direction to a null view with id: " + i);
                return;
        }
    }

    public void l(ArrayList arrayList) {
        com.google.firebase.storage.z zVar = (com.google.firebase.storage.z) this.f7163b;
        zVar.getClass();
        int i = arrayList.size() == 0 ? 5894 : 1798;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            int iOrdinal = ((Y3.c) arrayList.get(i6)).ordinal();
            if (iOrdinal == 0) {
                i &= -5;
            } else if (iOrdinal == 1) {
                i &= -515;
            }
        }
        zVar.f5629b = i;
        zVar.v();
    }

    public void m(int i) {
        View decorView = ((AbstractActivityC0229d) ((com.google.firebase.storage.z) this.f7163b).f5630c).getWindow().getDecorView();
        int iC = S.i.c(i);
        if (iC == 0) {
            decorView.performHapticFeedback(0);
            return;
        }
        if (iC == 1) {
            decorView.performHapticFeedback(1);
            return;
        }
        if (iC == 2) {
            decorView.performHapticFeedback(3);
        } else if (iC == 3) {
            decorView.performHapticFeedback(6);
        } else {
            if (iC != 4) {
                return;
            }
            decorView.performHapticFeedback(4);
        }
    }

    @Override // io.flutter.plugin.platform.g
    public void release() {
        ((TextureRegistry$SurfaceProducer) this.f7163b).release();
        this.f7163b = null;
    }

    @Override // io.flutter.plugin.platform.g
    public void scheduleFrame() {
        ((TextureRegistry$SurfaceProducer) this.f7163b).scheduleFrame();
    }

    public l(int i) {
        this.f7162a = i;
        switch (i) {
            case 4:
                break;
            default:
                this.f7163b = new HashMap();
                break;
        }
    }
}
