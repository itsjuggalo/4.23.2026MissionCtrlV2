package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes.dex */
public class e extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11077a;

    public e(Context context) {
        super(context);
        this.f11077a = true;
        super.setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z7) {
        this.f11077a = z7;
    }

    public void setGuidelineBegin(int i8) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f11077a && bVar.f10856a == i8) {
            return;
        }
        bVar.f10856a = i8;
        setLayoutParams(bVar);
    }

    public void setGuidelineEnd(int i8) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f11077a && bVar.f10858b == i8) {
            return;
        }
        bVar.f10858b = i8;
        setLayoutParams(bVar);
    }

    public void setGuidelinePercent(float f8) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        if (this.f11077a && bVar.f10860c == f8) {
            return;
        }
        bVar.f10860c = f8;
        setLayoutParams(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
    }
}
