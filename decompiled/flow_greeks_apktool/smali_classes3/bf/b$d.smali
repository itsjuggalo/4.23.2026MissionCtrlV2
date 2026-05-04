.class public abstract Lbf/b$d;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lbf/b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "d"
.end annotation


# instance fields
.field public final a:I

.field public final b:I


# direct methods
.method public constructor <init>(II)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput p1, p0, Lbf/b$d;->a:I

    .line 4
    iput p2, p0, Lbf/b$d;->b:I

    return-void
.end method

.method public synthetic constructor <init>(IILbf/b$a;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1, p2}, Lbf/b$d;-><init>(II)V

    return-void
.end method

.method public static a(Lbf/b$d;[Lgf/j$a;)Lbf/b$d;
    .locals 1

    .line 1
    iget v0, p0, Lbf/b$d;->a:I

    .line 2
    .line 3
    iget p0, p0, Lbf/b$d;->b:I

    .line 4
    .line 5
    add-int/2addr v0, p0

    .line 6
    new-instance p0, Lbf/b$c;

    .line 7
    .line 8
    invoke-direct {p0, v0, p1}, Lbf/b$c;-><init>(I[Lgf/j$a;)V

    .line 9
    .line 10
    .line 11
    return-object p0
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
.end method

.method public static b(Lbf/b$d;)Lbf/b$b;
    .locals 1

    .line 1
    iget v0, p0, Lbf/b$d;->a:I

    .line 2
    .line 3
    iget p0, p0, Lbf/b$d;->b:I

    .line 4
    .line 5
    add-int/2addr v0, p0

    .line 6
    new-instance p0, Lbf/b$b;

    .line 7
    .line 8
    invoke-direct {p0, v0}, Lbf/b$b;-><init>(I)V

    .line 9
    .line 10
    .line 11
    return-object p0
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
.end method

.method public static c()Lbf/b$b;
    .locals 2

    .line 1
    new-instance v0, Lbf/b$b;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1}, Lbf/b$b;-><init>(I)V

    .line 5
    .line 6
    .line 7
    return-object v0
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
.end method


# virtual methods
.method public abstract d(I)Ljava/lang/Object;
.end method

.method public abstract e(Ljava/lang/Object;)I
.end method
