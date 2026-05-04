.class public abstract Lcom/bumptech/glide/i;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# direct methods
.method public static a(Lcom/bumptech/glide/b;Ljava/util/List;Lw3/a;)Lcom/bumptech/glide/h;
    .locals 5

    .line 1
    invoke-virtual {p0}, Lcom/bumptech/glide/b;->f()Lj3/d;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {p0}, Lcom/bumptech/glide/b;->e()Lj3/b;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    invoke-virtual {p0}, Lcom/bumptech/glide/b;->i()Lcom/bumptech/glide/d;

    .line 10
    .line 11
    .line 12
    move-result-object v2

    .line 13
    invoke-virtual {v2}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    .line 14
    .line 15
    .line 16
    move-result-object v2

    .line 17
    invoke-virtual {p0}, Lcom/bumptech/glide/b;->i()Lcom/bumptech/glide/d;

    .line 18
    .line 19
    .line 20
    move-result-object v3

    .line 21
    invoke-virtual {v3}, Lcom/bumptech/glide/d;->f()Lcom/bumptech/glide/e;

    .line 22
    .line 23
    .line 24
    move-result-object v3

    .line 25
    new-instance v4, Lcom/bumptech/glide/h;

    .line 26
    .line 27
    invoke-direct {v4}, Lcom/bumptech/glide/h;-><init>()V

    .line 28
    .line 29
    .line 30
    invoke-static {v2, v4, v0, v1, v3}, Lcom/bumptech/glide/i;->b(Landroid/content/Context;Lcom/bumptech/glide/h;Lj3/d;Lj3/b;Lcom/bumptech/glide/e;)V

    .line 31
    .line 32
    .line 33
    invoke-static {v2, p0, v4, p1, p2}, Lcom/bumptech/glide/i;->c(Landroid/content/Context;Lcom/bumptech/glide/b;Lcom/bumptech/glide/h;Ljava/util/List;Lw3/a;)V

    .line 34
    .line 35
    .line 36
    return-object v4
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
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
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method

.method public static b(Landroid/content/Context;Lcom/bumptech/glide/h;Lj3/d;Lj3/b;Lcom/bumptech/glide/e;)V
    .locals 25

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    move-object/from16 v4, p4

    .line 1
    new-instance v5, Lp3/i;

    invoke-direct {v5}, Lp3/i;-><init>()V

    invoke-virtual {v1, v5}, Lcom/bumptech/glide/h;->o(Lcom/bumptech/glide/load/ImageHeaderParser;)Lcom/bumptech/glide/h;

    .line 2
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x1b

    if-lt v5, v6, :cond_0

    .line 3
    new-instance v6, Lp3/s;

    invoke-direct {v6}, Lp3/s;-><init>()V

    invoke-virtual {v1, v6}, Lcom/bumptech/glide/h;->o(Lcom/bumptech/glide/load/ImageHeaderParser;)Lcom/bumptech/glide/h;

    .line 4
    :cond_0
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    .line 5
    invoke-virtual {v1}, Lcom/bumptech/glide/h;->g()Ljava/util/List;

    move-result-object v7

    .line 6
    new-instance v8, Lt3/a;

    invoke-direct {v8, v0, v7, v2, v3}, Lt3/a;-><init>(Landroid/content/Context;Ljava/util/List;Lj3/d;Lj3/b;)V

    .line 7
    invoke-static {v2}, Lp3/i0;->m(Lj3/d;)Lg3/j;

    move-result-object v9

    .line 8
    new-instance v10, Lp3/p;

    .line 9
    invoke-virtual {v1}, Lcom/bumptech/glide/h;->g()Ljava/util/List;

    move-result-object v11

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v12

    invoke-direct {v10, v11, v12, v2, v3}, Lp3/p;-><init>(Ljava/util/List;Landroid/util/DisplayMetrics;Lj3/d;Lj3/b;)V

    const/16 v11, 0x1c

    if-lt v5, v11, :cond_1

    .line 10
    const-class v12, Lcom/bumptech/glide/c$b;

    .line 11
    invoke-virtual {v4, v12}, Lcom/bumptech/glide/e;->a(Ljava/lang/Class;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 12
    new-instance v12, Lp3/y;

    invoke-direct {v12}, Lp3/y;-><init>()V

    .line 13
    new-instance v13, Lp3/h;

    invoke-direct {v13}, Lp3/h;-><init>()V

    goto :goto_0

    .line 14
    :cond_1
    new-instance v13, Lp3/g;

    invoke-direct {v13, v10}, Lp3/g;-><init>(Lp3/p;)V

    .line 15
    new-instance v12, Lp3/d0;

    invoke-direct {v12, v10, v3}, Lp3/d0;-><init>(Lp3/p;Lj3/b;)V

    .line 16
    :goto_0
    const-string v14, "Animation"

    const-class v15, Ljava/nio/ByteBuffer;

    const-class v4, Landroid/graphics/drawable/Drawable;

    move-object/from16 v16, v8

    const-class v8, Ljava/io/InputStream;

    if-lt v5, v11, :cond_2

    .line 17
    invoke-static {v7, v3}, Lr3/c;->f(Ljava/util/List;Lj3/b;)Lg3/j;

    move-result-object v11

    .line 18
    invoke-virtual {v1, v14, v8, v4, v11}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    .line 19
    invoke-static {v7, v3}, Lr3/c;->a(Ljava/util/List;Lj3/b;)Lg3/j;

    move-result-object v11

    .line 20
    invoke-virtual {v1, v14, v15, v4, v11}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    .line 21
    :cond_2
    new-instance v11, Lr3/g;

    invoke-direct {v11, v0}, Lr3/g;-><init>(Landroid/content/Context;)V

    move/from16 v17, v5

    .line 22
    new-instance v5, Lp3/c;

    invoke-direct {v5, v3}, Lp3/c;-><init>(Lj3/b;)V

    .line 23
    new-instance v0, Lu3/a;

    invoke-direct {v0}, Lu3/a;-><init>()V

    move-object/from16 v18, v0

    .line 24
    new-instance v0, Lu3/d;

    invoke-direct {v0}, Lu3/d;-><init>()V

    move-object/from16 v19, v0

    .line 25
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    move-object/from16 v20, v0

    .line 26
    new-instance v0, Lm3/c;

    invoke-direct {v0}, Lm3/c;-><init>()V

    .line 27
    invoke-virtual {v1, v15, v0}, Lcom/bumptech/glide/h;->a(Ljava/lang/Class;Lg3/d;)Lcom/bumptech/glide/h;

    move-result-object v0

    move-object/from16 v21, v4

    new-instance v4, Lm3/u;

    invoke-direct {v4, v3}, Lm3/u;-><init>(Lj3/b;)V

    .line 28
    invoke-virtual {v0, v8, v4}, Lcom/bumptech/glide/h;->a(Ljava/lang/Class;Lg3/d;)Lcom/bumptech/glide/h;

    move-result-object v0

    .line 29
    const-string v4, "Bitmap"

    move-object/from16 v22, v11

    const-class v11, Landroid/graphics/Bitmap;

    invoke-virtual {v0, v4, v15, v11, v13}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v0

    .line 30
    invoke-virtual {v0, v4, v8, v11, v12}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    .line 31
    invoke-static {}, Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;->c()Z

    move-result v0

    move/from16 v23, v0

    const-class v0, Landroid/os/ParcelFileDescriptor;

    if-eqz v23, :cond_3

    move-object/from16 v23, v14

    .line 32
    new-instance v14, Lp3/a0;

    invoke-direct {v14, v10}, Lp3/a0;-><init>(Lp3/p;)V

    invoke-virtual {v1, v4, v0, v11, v14}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    goto :goto_1

    :cond_3
    move-object/from16 v23, v14

    .line 33
    :goto_1
    invoke-static {v2}, Lp3/i0;->c(Lj3/d;)Lg3/j;

    move-result-object v10

    .line 34
    const-class v14, Landroid/content/res/AssetFileDescriptor;

    invoke-virtual {v1, v4, v14, v11, v10}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    .line 35
    invoke-virtual {v1, v4, v0, v11, v9}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v10

    move-object/from16 v24, v14

    .line 36
    invoke-static {}, Lm3/w$a;->a()Lm3/w$a;

    move-result-object v14

    invoke-virtual {v10, v11, v11, v14}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v10

    new-instance v14, Lp3/f0;

    invoke-direct {v14}, Lp3/f0;-><init>()V

    .line 37
    invoke-virtual {v10, v4, v11, v11, v14}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v10

    .line 38
    invoke-virtual {v10, v11, v5}, Lcom/bumptech/glide/h;->b(Ljava/lang/Class;Lg3/k;)Lcom/bumptech/glide/h;

    move-result-object v10

    new-instance v14, Lp3/a;

    invoke-direct {v14, v6, v13}, Lp3/a;-><init>(Landroid/content/res/Resources;Lg3/j;)V

    .line 39
    const-string v13, "BitmapDrawable"

    const-class v1, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v10, v13, v15, v1, v14}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v10

    new-instance v14, Lp3/a;

    invoke-direct {v14, v6, v12}, Lp3/a;-><init>(Landroid/content/res/Resources;Lg3/j;)V

    .line 40
    invoke-virtual {v10, v13, v8, v1, v14}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v10

    new-instance v12, Lp3/a;

    invoke-direct {v12, v6, v9}, Lp3/a;-><init>(Landroid/content/res/Resources;Lg3/j;)V

    .line 41
    invoke-virtual {v10, v13, v0, v1, v12}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v9

    new-instance v10, Lp3/b;

    invoke-direct {v10, v2, v5}, Lp3/b;-><init>(Lj3/d;Lg3/k;)V

    .line 42
    invoke-virtual {v9, v1, v10}, Lcom/bumptech/glide/h;->b(Ljava/lang/Class;Lg3/k;)Lcom/bumptech/glide/h;

    move-result-object v5

    new-instance v9, Lt3/j;

    move-object/from16 v10, v16

    invoke-direct {v9, v7, v10, v3}, Lt3/j;-><init>(Ljava/util/List;Lg3/j;Lj3/b;)V

    .line 43
    const-class v7, Lt3/c;

    move-object/from16 v12, v23

    invoke-virtual {v5, v12, v8, v7, v9}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v5

    .line 44
    invoke-virtual {v5, v12, v15, v7, v10}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v5

    new-instance v9, Lt3/d;

    invoke-direct {v9}, Lt3/d;-><init>()V

    .line 45
    invoke-virtual {v5, v7, v9}, Lcom/bumptech/glide/h;->b(Ljava/lang/Class;Lg3/k;)Lcom/bumptech/glide/h;

    move-result-object v5

    .line 46
    invoke-static {}, Lm3/w$a;->a()Lm3/w$a;

    move-result-object v9

    .line 47
    const-class v10, Lf3/a;

    invoke-virtual {v5, v10, v10, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v5

    new-instance v9, Lt3/h;

    invoke-direct {v9, v2}, Lt3/h;-><init>(Lj3/d;)V

    .line 48
    invoke-virtual {v5, v4, v10, v11, v9}, Lcom/bumptech/glide/h;->e(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v4

    .line 49
    const-class v5, Landroid/net/Uri;

    move-object/from16 v10, v21

    move-object/from16 v9, v22

    invoke-virtual {v4, v5, v10, v9}, Lcom/bumptech/glide/h;->c(Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v4

    new-instance v12, Lp3/c0;

    invoke-direct {v12, v9, v2}, Lp3/c0;-><init>(Lr3/g;Lj3/d;)V

    .line 50
    invoke-virtual {v4, v5, v11, v12}, Lcom/bumptech/glide/h;->c(Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v4

    new-instance v9, Lq3/a$a;

    invoke-direct {v9}, Lq3/a$a;-><init>()V

    .line 51
    invoke-virtual {v4, v9}, Lcom/bumptech/glide/h;->p(Lcom/bumptech/glide/load/data/e$a;)Lcom/bumptech/glide/h;

    move-result-object v4

    new-instance v9, Lm3/d$b;

    invoke-direct {v9}, Lm3/d$b;-><init>()V

    .line 52
    const-class v12, Ljava/io/File;

    invoke-virtual {v4, v12, v15, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v4

    new-instance v9, Lm3/g$e;

    invoke-direct {v9}, Lm3/g$e;-><init>()V

    .line 53
    invoke-virtual {v4, v12, v8, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v4

    new-instance v9, Ls3/a;

    invoke-direct {v9}, Ls3/a;-><init>()V

    .line 54
    invoke-virtual {v4, v12, v12, v9}, Lcom/bumptech/glide/h;->c(Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v4

    new-instance v9, Lm3/g$b;

    invoke-direct {v9}, Lm3/g$b;-><init>()V

    .line 55
    invoke-virtual {v4, v12, v0, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v4

    .line 56
    invoke-static {}, Lm3/w$a;->a()Lm3/w$a;

    move-result-object v9

    invoke-virtual {v4, v12, v12, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v4

    new-instance v9, Lcom/bumptech/glide/load/data/k$a;

    invoke-direct {v9, v3}, Lcom/bumptech/glide/load/data/k$a;-><init>(Lj3/b;)V

    .line 57
    invoke-virtual {v4, v9}, Lcom/bumptech/glide/h;->p(Lcom/bumptech/glide/load/data/e$a;)Lcom/bumptech/glide/h;

    .line 58
    invoke-static {}, Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder;->c()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 59
    new-instance v3, Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder$a;

    invoke-direct {v3}, Lcom/bumptech/glide/load/data/ParcelFileDescriptorRewinder$a;-><init>()V

    move-object/from16 v4, p1

    invoke-virtual {v4, v3}, Lcom/bumptech/glide/h;->p(Lcom/bumptech/glide/load/data/e$a;)Lcom/bumptech/glide/h;

    goto :goto_2

    :cond_4
    move-object/from16 v4, p1

    .line 60
    :goto_2
    invoke-static/range {p0 .. p0}, Lm3/f;->g(Landroid/content/Context;)Lm3/o;

    move-result-object v3

    .line 61
    invoke-static/range {p0 .. p0}, Lm3/f;->c(Landroid/content/Context;)Lm3/o;

    move-result-object v9

    .line 62
    invoke-static/range {p0 .. p0}, Lm3/f;->e(Landroid/content/Context;)Lm3/o;

    move-result-object v13

    .line 63
    sget-object v14, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    move-object/from16 v16, v7

    invoke-virtual {v4, v14, v8, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v7

    .line 64
    const-class v2, Ljava/lang/Integer;

    invoke-virtual {v7, v2, v8, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v3

    move-object/from16 v7, v24

    .line 65
    invoke-virtual {v3, v14, v7, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v3

    .line 66
    invoke-virtual {v3, v2, v7, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v3

    .line 67
    invoke-virtual {v3, v14, v10, v13}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v3

    .line 68
    invoke-virtual {v3, v2, v10, v13}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v3

    .line 69
    invoke-static/range {p0 .. p0}, Lm3/t;->f(Landroid/content/Context;)Lm3/o;

    move-result-object v9

    invoke-virtual {v3, v5, v8, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v3

    .line 70
    invoke-static/range {p0 .. p0}, Lm3/t;->e(Landroid/content/Context;)Lm3/o;

    move-result-object v9

    .line 71
    invoke-virtual {v3, v5, v7, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    .line 72
    new-instance v3, Lm3/s$c;

    invoke-direct {v3, v6}, Lm3/s$c;-><init>(Landroid/content/res/Resources;)V

    .line 73
    new-instance v9, Lm3/s$a;

    invoke-direct {v9, v6}, Lm3/s$a;-><init>(Landroid/content/res/Resources;)V

    .line 74
    new-instance v13, Lm3/s$b;

    invoke-direct {v13, v6}, Lm3/s$b;-><init>(Landroid/content/res/Resources;)V

    move-object/from16 v21, v1

    .line 75
    invoke-virtual {v4, v2, v5, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    .line 76
    invoke-virtual {v1, v14, v5, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    .line 77
    invoke-virtual {v1, v2, v7, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    .line 78
    invoke-virtual {v1, v14, v7, v9}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    .line 79
    invoke-virtual {v1, v2, v8, v13}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    .line 80
    invoke-virtual {v1, v14, v8, v13}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    .line 81
    new-instance v1, Lm3/e$c;

    invoke-direct {v1}, Lm3/e$c;-><init>()V

    .line 82
    const-class v2, Ljava/lang/String;

    invoke-virtual {v4, v2, v8, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v3, Lm3/e$c;

    invoke-direct {v3}, Lm3/e$c;-><init>()V

    .line 83
    invoke-virtual {v1, v5, v8, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v3, Lm3/v$c;

    invoke-direct {v3}, Lm3/v$c;-><init>()V

    .line 84
    invoke-virtual {v1, v2, v8, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v3, Lm3/v$b;

    invoke-direct {v3}, Lm3/v$b;-><init>()V

    .line 85
    invoke-virtual {v1, v2, v0, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v3, Lm3/v$a;

    invoke-direct {v3}, Lm3/v$a;-><init>()V

    .line 86
    invoke-virtual {v1, v2, v7, v3}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v2, Lm3/a$c;

    .line 87
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v3

    invoke-direct {v2, v3}, Lm3/a$c;-><init>(Landroid/content/res/AssetManager;)V

    invoke-virtual {v1, v5, v8, v2}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v2, Lm3/a$b;

    .line 88
    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v3

    invoke-direct {v2, v3}, Lm3/a$b;-><init>(Landroid/content/res/AssetManager;)V

    .line 89
    invoke-virtual {v1, v5, v7, v2}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v2, Ln3/b$a;

    move-object/from16 v3, p0

    invoke-direct {v2, v3}, Ln3/b$a;-><init>(Landroid/content/Context;)V

    .line 90
    invoke-virtual {v1, v5, v8, v2}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v1

    new-instance v2, Ln3/c$a;

    invoke-direct {v2, v3}, Ln3/c$a;-><init>(Landroid/content/Context;)V

    .line 91
    invoke-virtual {v1, v5, v8, v2}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    const/16 v1, 0x1d

    move/from16 v2, v17

    if-lt v2, v1, :cond_5

    .line 92
    new-instance v1, Ln3/d$c;

    invoke-direct {v1, v3}, Ln3/d$c;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v5, v8, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    .line 93
    new-instance v1, Ln3/d$b;

    invoke-direct {v1, v3}, Ln3/d$b;-><init>(Landroid/content/Context;)V

    invoke-virtual {v4, v5, v0, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    .line 94
    :cond_5
    const-class v1, Lcom/bumptech/glide/c$e;

    move-object/from16 v2, p4

    .line 95
    invoke-virtual {v2, v1}, Lcom/bumptech/glide/e;->a(Ljava/lang/Class;)Z

    move-result v1

    .line 96
    new-instance v2, Lm3/x$d;

    move-object/from16 v9, v20

    invoke-direct {v2, v9, v1}, Lm3/x$d;-><init>(Landroid/content/ContentResolver;Z)V

    .line 97
    invoke-virtual {v4, v5, v8, v2}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v2

    new-instance v13, Lm3/x$b;

    invoke-direct {v13, v9, v1}, Lm3/x$b;-><init>(Landroid/content/ContentResolver;Z)V

    .line 98
    invoke-virtual {v2, v5, v0, v13}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v2, Lm3/x$a;

    invoke-direct {v2, v9, v1}, Lm3/x$a;-><init>(Landroid/content/ContentResolver;Z)V

    .line 99
    invoke-virtual {v0, v5, v7, v2}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Lm3/y$a;

    invoke-direct {v1}, Lm3/y$a;-><init>()V

    .line 100
    invoke-virtual {v0, v5, v8, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Ln3/e$a;

    invoke-direct {v1}, Ln3/e$a;-><init>()V

    .line 101
    const-class v2, Ljava/net/URL;

    invoke-virtual {v0, v2, v8, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Lm3/l$a;

    invoke-direct {v1, v3}, Lm3/l$a;-><init>(Landroid/content/Context;)V

    .line 102
    invoke-virtual {v0, v5, v12, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Ln3/a$a;

    invoke-direct {v1}, Ln3/a$a;-><init>()V

    .line 103
    const-class v2, Lm3/h;

    invoke-virtual {v0, v2, v8, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Lm3/b$a;

    invoke-direct {v1}, Lm3/b$a;-><init>()V

    .line 104
    const-class v2, [B

    invoke-virtual {v0, v2, v15, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Lm3/b$d;

    invoke-direct {v1}, Lm3/b$d;-><init>()V

    .line 105
    invoke-virtual {v0, v2, v8, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    .line 106
    invoke-static {}, Lm3/w$a;->a()Lm3/w$a;

    move-result-object v1

    invoke-virtual {v0, v5, v5, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    .line 107
    invoke-static {}, Lm3/w$a;->a()Lm3/w$a;

    move-result-object v1

    invoke-virtual {v0, v10, v10, v1}, Lcom/bumptech/glide/h;->d(Ljava/lang/Class;Ljava/lang/Class;Lm3/o;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Lr3/h;

    invoke-direct {v1}, Lr3/h;-><init>()V

    .line 108
    invoke-virtual {v0, v10, v10, v1}, Lcom/bumptech/glide/h;->c(Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v1, Lu3/b;

    invoke-direct {v1, v6}, Lu3/b;-><init>(Landroid/content/res/Resources;)V

    move-object/from16 v3, v21

    .line 109
    invoke-virtual {v0, v11, v3, v1}, Lcom/bumptech/glide/h;->q(Ljava/lang/Class;Ljava/lang/Class;Lu3/e;)Lcom/bumptech/glide/h;

    move-result-object v0

    move-object/from16 v1, v18

    .line 110
    invoke-virtual {v0, v11, v2, v1}, Lcom/bumptech/glide/h;->q(Ljava/lang/Class;Ljava/lang/Class;Lu3/e;)Lcom/bumptech/glide/h;

    move-result-object v0

    new-instance v5, Lu3/c;

    move-object/from16 v7, p2

    move-object/from16 v8, v19

    invoke-direct {v5, v7, v1, v8}, Lu3/c;-><init>(Lj3/d;Lu3/e;Lu3/e;)V

    .line 111
    invoke-virtual {v0, v10, v2, v5}, Lcom/bumptech/glide/h;->q(Ljava/lang/Class;Ljava/lang/Class;Lu3/e;)Lcom/bumptech/glide/h;

    move-result-object v0

    move-object/from16 v1, v16

    .line 112
    invoke-virtual {v0, v1, v2, v8}, Lcom/bumptech/glide/h;->q(Ljava/lang/Class;Ljava/lang/Class;Lu3/e;)Lcom/bumptech/glide/h;

    .line 113
    invoke-static {v7}, Lp3/i0;->d(Lj3/d;)Lg3/j;

    move-result-object v0

    .line 114
    invoke-virtual {v4, v15, v11, v0}, Lcom/bumptech/glide/h;->c(Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    .line 115
    new-instance v1, Lp3/a;

    invoke-direct {v1, v6, v0}, Lp3/a;-><init>(Landroid/content/res/Resources;Lg3/j;)V

    invoke-virtual {v4, v15, v3, v1}, Lcom/bumptech/glide/h;->c(Ljava/lang/Class;Ljava/lang/Class;Lg3/j;)Lcom/bumptech/glide/h;

    return-void
.end method

.method public static c(Landroid/content/Context;Lcom/bumptech/glide/b;Lcom/bumptech/glide/h;Ljava/util/List;Lw3/a;)V
    .locals 1

    .line 1
    invoke-interface {p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    .line 2
    .line 3
    .line 4
    move-result-object p3

    .line 5
    invoke-interface {p3}, Ljava/util/Iterator;->hasNext()Z

    .line 6
    .line 7
    .line 8
    move-result v0

    .line 9
    if-nez v0, :cond_1

    .line 10
    .line 11
    if-eqz p4, :cond_0

    .line 12
    .line 13
    invoke-virtual {p4, p0, p1, p2}, Lw3/c;->a(Landroid/content/Context;Lcom/bumptech/glide/b;Lcom/bumptech/glide/h;)V

    .line 14
    .line 15
    .line 16
    :cond_0
    return-void

    .line 17
    :cond_1
    invoke-interface {p3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    .line 18
    .line 19
    .line 20
    move-result-object p0

    .line 21
    invoke-static {p0}, Landroid/support/v4/media/session/b;->a(Ljava/lang/Object;)V

    .line 22
    .line 23
    .line 24
    const/4 p0, 0x0

    .line 25
    throw p0
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
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
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
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
    .line 98
    .line 99
    .line 100
    .line 101
    .line 102
    .line 103
    .line 104
    .line 105
    .line 106
    .line 107
    .line 108
    .line 109
    .line 110
    .line 111
    .line 112
    .line 113
    .line 114
    .line 115
    .line 116
    .line 117
    .line 118
    .line 119
    .line 120
    .line 121
    .line 122
    .line 123
    .line 124
    .line 125
    .line 126
    .line 127
    .line 128
    .line 129
    .line 130
    .line 131
    .line 132
    .line 133
    .line 134
    .line 135
    .line 136
    .line 137
    .line 138
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
    .line 197
    .line 198
    .line 199
    .line 200
    .line 201
    .line 202
    .line 203
    .line 204
    .line 205
    .line 206
    .line 207
    .line 208
    .line 209
    .line 210
    .line 211
    .line 212
    .line 213
    .line 214
    .line 215
    .line 216
    .line 217
    .line 218
    .line 219
    .line 220
    .line 221
    .line 222
    .line 223
    .line 224
    .line 225
    .line 226
    .line 227
    .line 228
    .line 229
    .line 230
    .line 231
    .line 232
    .line 233
    .line 234
    .line 235
    .line 236
    .line 237
    .line 238
    .line 239
    .line 240
    .line 241
    .line 242
    .line 243
    .line 244
    .line 245
    .line 246
    .line 247
    .line 248
    .line 249
    .line 250
    .line 251
    .line 252
    .line 253
    .line 254
    .line 255
    .line 256
    .line 257
    .line 258
    .line 259
    .line 260
    .line 261
    .line 262
    .line 263
    .line 264
    .line 265
    .line 266
    .line 267
    .line 268
    .line 269
    .line 270
    .line 271
    .line 272
    .line 273
    .line 274
    .line 275
    .line 276
    .line 277
    .line 278
    .line 279
    .line 280
    .line 281
    .line 282
    .line 283
    .line 284
    .line 285
    .line 286
    .line 287
    .line 288
    .line 289
    .line 290
    .line 291
    .line 292
    .line 293
    .line 294
    .line 295
    .line 296
    .line 297
    .line 298
    .line 299
    .line 300
    .line 301
    .line 302
    .line 303
    .line 304
    .line 305
    .line 306
    .line 307
    .line 308
    .line 309
    .line 310
    .line 311
    .line 312
    .line 313
    .line 314
    .line 315
    .line 316
    .line 317
    .line 318
    .line 319
    .line 320
    .line 321
    .line 322
    .line 323
    .line 324
    .line 325
    .line 326
    .line 327
    .line 328
    .line 329
    .line 330
    .line 331
    .line 332
    .line 333
    .line 334
    .line 335
    .line 336
    .line 337
    .line 338
    .line 339
    .line 340
    .line 341
    .line 342
    .line 343
    .line 344
    .line 345
    .line 346
    .line 347
    .line 348
    .line 349
    .line 350
    .line 351
    .line 352
    .line 353
    .line 354
    .line 355
    .line 356
    .line 357
    .line 358
    .line 359
    .line 360
    .line 361
    .line 362
    .line 363
    .line 364
    .line 365
    .line 366
    .line 367
    .line 368
    .line 369
    .line 370
    .line 371
    .line 372
    .line 373
.end method

.method public static d(Lcom/bumptech/glide/b;Ljava/util/List;Lw3/a;)Lc4/f$b;
    .locals 1

    .line 1
    new-instance v0, Lcom/bumptech/glide/i$a;

    .line 2
    .line 3
    invoke-direct {v0, p0, p1, p2}, Lcom/bumptech/glide/i$a;-><init>(Lcom/bumptech/glide/b;Ljava/util/List;Lw3/a;)V

    .line 4
    .line 5
    .line 6
    return-object v0
    .line 7
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
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
    .line 49
    .line 50
    .line 51
    .line 52
    .line 53
    .line 54
    .line 55
    .line 56
    .line 57
    .line 58
    .line 59
    .line 60
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
    .line 72
    .line 73
    .line 74
    .line 75
    .line 76
    .line 77
    .line 78
    .line 79
    .line 80
    .line 81
    .line 82
    .line 83
    .line 84
    .line 85
    .line 86
    .line 87
    .line 88
.end method
