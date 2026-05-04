.class public Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;
.super Lo/k;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;
    }
.end annotation


# instance fields
.field public d:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lo/k;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0, p1}, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->e(Landroid/content/Context;)V

    .line 5
    .line 6
    .line 7
    return-void
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public final c(II)Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;
    .locals 4

    .line 1
    invoke-virtual {p0}, Landroid/widget/ImageView;->getMaxWidth()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-virtual {p0}, Landroid/widget/ImageView;->getMaxHeight()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    if-le p1, v0, :cond_0

    .line 10
    .line 11
    const-string v2, "Image: capping width"

    .line 12
    .line 13
    int-to-float v3, v0

    .line 14
    invoke-static {v2, v3}, Lu9/l;->c(Ljava/lang/String;F)V

    .line 15
    .line 16
    .line 17
    mul-int/2addr p2, v0

    .line 18
    div-int/2addr p2, p1

    .line 19
    move p1, v0

    .line 20
    :cond_0
    if-le p2, v1, :cond_1

    .line 21
    .line 22
    const-string v0, "Image: capping height"

    .line 23
    .line 24
    int-to-float v2, v1

    .line 25
    invoke-static {v0, v2}, Lu9/l;->c(Ljava/lang/String;F)V

    .line 26
    .line 27
    .line 28
    mul-int/2addr p1, v1

    .line 29
    div-int/2addr p1, p2

    .line 30
    goto :goto_0

    .line 31
    :cond_1
    move v1, p2

    .line 32
    :goto_0
    new-instance p2, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;

    .line 33
    .line 34
    const/4 v0, 0x0

    .line 35
    invoke-direct {p2, p1, v1, v0}, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;-><init>(IILcom/google/firebase/inappmessaging/display/internal/ResizableImageView$a;)V

    .line 36
    .line 37
    .line 38
    return-object p2
    .line 39
.end method

.method public final d()V
    .locals 10

    .line 1
    invoke-virtual {p0}, Landroid/view/View;->getMinimumWidth()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-virtual {p0}, Landroid/view/View;->getSuggestedMinimumWidth()I

    .line 6
    .line 7
    .line 8
    move-result v1

    .line 9
    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    .line 10
    .line 11
    .line 12
    move-result v0

    .line 13
    invoke-virtual {p0}, Landroid/view/View;->getMinimumHeight()I

    .line 14
    .line 15
    .line 16
    move-result v1

    .line 17
    invoke-virtual {p0}, Landroid/view/View;->getSuggestedMinimumHeight()I

    .line 18
    .line 19
    .line 20
    move-result v2

    .line 21
    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    .line 22
    .line 23
    .line 24
    move-result v1

    .line 25
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredWidth()I

    .line 26
    .line 27
    .line 28
    move-result v2

    .line 29
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredHeight()I

    .line 30
    .line 31
    .line 32
    move-result v3

    .line 33
    int-to-float v4, v0

    .line 34
    int-to-float v5, v1

    .line 35
    const-string v6, "Image: min width, height"

    .line 36
    .line 37
    invoke-static {v6, v4, v5}, Lu9/l;->d(Ljava/lang/String;FF)V

    .line 38
    .line 39
    .line 40
    int-to-float v6, v2

    .line 41
    int-to-float v7, v3

    .line 42
    const-string v8, "Image: actual width, height"

    .line 43
    .line 44
    invoke-static {v8, v6, v7}, Lu9/l;->d(Ljava/lang/String;FF)V

    .line 45
    .line 46
    .line 47
    const/high16 v8, 0x3f800000    # 1.0f

    .line 48
    .line 49
    if-ge v2, v0, :cond_0

    .line 50
    .line 51
    div-float/2addr v4, v6

    .line 52
    goto :goto_0

    .line 53
    :cond_0
    move v4, v8

    .line 54
    :goto_0
    if-ge v3, v1, :cond_1

    .line 55
    .line 56
    div-float v8, v5, v7

    .line 57
    .line 58
    :cond_1
    cmpl-float v0, v4, v8

    .line 59
    .line 60
    if-lez v0, :cond_2

    .line 61
    .line 62
    goto :goto_1

    .line 63
    :cond_2
    move v4, v8

    .line 64
    :goto_1
    float-to-double v0, v4

    .line 65
    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    .line 66
    .line 67
    cmpl-double v0, v0, v8

    .line 68
    .line 69
    if-lez v0, :cond_3

    .line 70
    .line 71
    mul-float/2addr v6, v4

    .line 72
    float-to-double v0, v6

    .line 73
    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    .line 74
    .line 75
    .line 76
    move-result-wide v0

    .line 77
    double-to-int v0, v0

    .line 78
    mul-float/2addr v7, v4

    .line 79
    float-to-double v4, v7

    .line 80
    invoke-static {v4, v5}, Ljava/lang/Math;->ceil(D)D

    .line 81
    .line 82
    .line 83
    move-result-wide v4

    .line 84
    double-to-int v1, v4

    .line 85
    new-instance v4, Ljava/lang/StringBuilder;

    .line 86
    .line 87
    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 88
    .line 89
    .line 90
    const-string v5, "Measured dimension ("

    .line 91
    .line 92
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 93
    .line 94
    .line 95
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 96
    .line 97
    .line 98
    const-string v2, "x"

    .line 99
    .line 100
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 101
    .line 102
    .line 103
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 104
    .line 105
    .line 106
    const-string v3, ") too small.  Resizing to "

    .line 107
    .line 108
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 109
    .line 110
    .line 111
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 112
    .line 113
    .line 114
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 115
    .line 116
    .line 117
    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 118
    .line 119
    .line 120
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 121
    .line 122
    .line 123
    move-result-object v2

    .line 124
    invoke-static {v2}, Lu9/l;->a(Ljava/lang/String;)V

    .line 125
    .line 126
    .line 127
    invoke-virtual {p0, v0, v1}, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->c(II)Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;

    .line 128
    .line 129
    .line 130
    move-result-object v0

    .line 131
    iget v1, v0, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;->a:I

    .line 132
    .line 133
    iget v0, v0, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;->b:I

    .line 134
    .line 135
    invoke-virtual {p0, v1, v0}, Landroid/view/View;->setMeasuredDimension(II)V

    .line 136
    .line 137
    .line 138
    :cond_3
    return-void
    .line 139
    .line 140
    .line 141
    .line 142
    .line 143
    .line 144
    .line 145
    .line 146
    .line 147
    .line 148
    .line 149
    .line 150
    .line 151
    .line 152
    .line 153
    .line 154
    .line 155
    .line 156
    .line 157
    .line 158
    .line 159
    .line 160
    .line 161
    .line 162
    .line 163
    .line 164
    .line 165
    .line 166
    .line 167
    .line 168
    .line 169
    .line 170
    .line 171
    .line 172
    .line 173
    .line 174
    .line 175
    .line 176
    .line 177
    .line 178
    .line 179
    .line 180
    .line 181
    .line 182
    .line 183
    .line 184
    .line 185
    .line 186
    .line 187
    .line 188
    .line 189
    .line 190
    .line 191
    .line 192
    .line 193
    .line 194
    .line 195
    .line 196
.end method

.method public final e(Landroid/content/Context;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    iget p1, p1, Landroid/util/DisplayMetrics;->density:F

    .line 10
    .line 11
    const/high16 v0, 0x43200000    # 160.0f

    .line 12
    .line 13
    mul-float/2addr p1, v0

    .line 14
    float-to-int p1, p1

    .line 15
    iput p1, p0, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->d:I

    .line 16
    .line 17
    return-void
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method public final f(Landroid/graphics/drawable/Drawable;)V
    .locals 4

    .line 1
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    .line 2
    .line 3
    .line 4
    move-result v0

    .line 5
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    .line 6
    .line 7
    .line 8
    move-result p1

    .line 9
    int-to-float v1, v0

    .line 10
    int-to-float v2, p1

    .line 11
    const-string v3, "Image: intrinsic width, height"

    .line 12
    .line 13
    invoke-static {v3, v1, v2}, Lu9/l;->d(Ljava/lang/String;FF)V

    .line 14
    .line 15
    .line 16
    iget v1, p0, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->d:I

    .line 17
    .line 18
    mul-int/2addr v0, v1

    .line 19
    div-int/lit16 v0, v0, 0xa0

    .line 20
    .line 21
    int-to-double v0, v0

    .line 22
    invoke-static {v0, v1}, Ljava/lang/Math;->ceil(D)D

    .line 23
    .line 24
    .line 25
    move-result-wide v0

    .line 26
    double-to-int v0, v0

    .line 27
    iget v1, p0, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->d:I

    .line 28
    .line 29
    mul-int/2addr p1, v1

    .line 30
    div-int/lit16 p1, p1, 0xa0

    .line 31
    .line 32
    int-to-double v1, p1

    .line 33
    invoke-static {v1, v2}, Ljava/lang/Math;->ceil(D)D

    .line 34
    .line 35
    .line 36
    move-result-wide v1

    .line 37
    double-to-int p1, v1

    .line 38
    invoke-virtual {p0, v0, p1}, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->c(II)Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;

    .line 39
    .line 40
    .line 41
    move-result-object p1

    .line 42
    iget v0, p1, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;->a:I

    .line 43
    .line 44
    int-to-float v0, v0

    .line 45
    iget v1, p1, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;->b:I

    .line 46
    .line 47
    int-to-float v1, v1

    .line 48
    const-string v2, "Image: new target dimensions"

    .line 49
    .line 50
    invoke-static {v2, v0, v1}, Lu9/l;->d(Ljava/lang/String;FF)V

    .line 51
    .line 52
    .line 53
    iget v0, p1, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;->a:I

    .line 54
    .line 55
    iget p1, p1, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView$b;->b:I

    .line 56
    .line 57
    invoke-virtual {p0, v0, p1}, Landroid/view/View;->setMeasuredDimension(II)V

    .line 58
    .line 59
    .line 60
    return-void
    .line 61
    .line 62
    .line 63
    .line 64
    .line 65
    .line 66
    .line 67
    .line 68
    .line 69
    .line 70
    .line 71
.end method

.method public onMeasure(II)V
    .locals 0

    .line 1
    invoke-super {p0, p1, p2}, Landroid/view/View;->onMeasure(II)V

    .line 2
    .line 3
    .line 4
    invoke-virtual {p0}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    .line 5
    .line 6
    .line 7
    move-result-object p1

    .line 8
    invoke-virtual {p0}, Landroid/widget/ImageView;->getAdjustViewBounds()Z

    .line 9
    .line 10
    .line 11
    move-result p2

    .line 12
    if-eqz p1, :cond_0

    .line 13
    .line 14
    if-eqz p2, :cond_0

    .line 15
    .line 16
    invoke-virtual {p0, p1}, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->f(Landroid/graphics/drawable/Drawable;)V

    .line 17
    .line 18
    .line 19
    invoke-virtual {p0}, Lcom/google/firebase/inappmessaging/display/internal/ResizableImageView;->d()V

    .line 20
    .line 21
    .line 22
    :cond_0
    return-void
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method
