.class public Li3/k$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Li3/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field public final a:Li3/h$e;

.field public final b:Ls0/c;

.field public c:I


# direct methods
.method public constructor <init>(Li3/h$e;)V
    .locals 2

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    new-instance v0, Li3/k$a$a;

    .line 5
    .line 6
    invoke-direct {v0, p0}, Li3/k$a$a;-><init>(Li3/k$a;)V

    .line 7
    .line 8
    .line 9
    const/16 v1, 0x96

    .line 10
    .line 11
    invoke-static {v1, v0}, Ld4/a;->d(ILd4/a$d;)Ls0/c;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    iput-object v0, p0, Li3/k$a;->b:Ls0/c;

    .line 16
    .line 17
    iput-object p1, p0, Li3/k$a;->a:Li3/h$e;

    .line 18
    .line 19
    return-void
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public a(Lcom/bumptech/glide/d;Ljava/lang/Object;Li3/n;Lg3/f;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/g;Li3/j;Ljava/util/Map;ZZZLg3/h;Li3/h$b;)Li3/h;
    .locals 20

    .line 1
    move-object/from16 v0, p0

    .line 2
    .line 3
    iget-object v1, v0, Li3/k$a;->b:Ls0/c;

    .line 4
    .line 5
    invoke-interface {v1}, Ls0/c;->b()Ljava/lang/Object;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    check-cast v1, Li3/h;

    .line 10
    .line 11
    invoke-static {v1}, Lc4/k;->e(Ljava/lang/Object;)Ljava/lang/Object;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    move-object v2, v1

    .line 16
    check-cast v2, Li3/h;

    .line 17
    .line 18
    iget v1, v0, Li3/k$a;->c:I

    .line 19
    .line 20
    add-int/lit8 v3, v1, 0x1

    .line 21
    .line 22
    iput v3, v0, Li3/k$a;->c:I

    .line 23
    .line 24
    move-object/from16 v3, p1

    .line 25
    .line 26
    move-object/from16 v4, p2

    .line 27
    .line 28
    move-object/from16 v5, p3

    .line 29
    .line 30
    move-object/from16 v6, p4

    .line 31
    .line 32
    move/from16 v7, p5

    .line 33
    .line 34
    move/from16 v8, p6

    .line 35
    .line 36
    move-object/from16 v9, p7

    .line 37
    .line 38
    move-object/from16 v10, p8

    .line 39
    .line 40
    move-object/from16 v11, p9

    .line 41
    .line 42
    move-object/from16 v12, p10

    .line 43
    .line 44
    move-object/from16 v13, p11

    .line 45
    .line 46
    move/from16 v14, p12

    .line 47
    .line 48
    move/from16 v15, p13

    .line 49
    .line 50
    move/from16 v16, p14

    .line 51
    .line 52
    move-object/from16 v17, p15

    .line 53
    .line 54
    move-object/from16 v18, p16

    .line 55
    .line 56
    move/from16 v19, v1

    .line 57
    .line 58
    invoke-virtual/range {v2 .. v19}, Li3/h;->w(Lcom/bumptech/glide/d;Ljava/lang/Object;Li3/n;Lg3/f;IILjava/lang/Class;Ljava/lang/Class;Lcom/bumptech/glide/g;Li3/j;Ljava/util/Map;ZZZLg3/h;Li3/h$b;I)Li3/h;

    .line 59
    .line 60
    .line 61
    move-result-object v1

    .line 62
    return-object v1
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
.end method
