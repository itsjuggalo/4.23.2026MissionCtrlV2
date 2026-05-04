.class public final Ltb/g1$s$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/g1$s;->f(Lrb/p;Lrb/r0$j;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "b"
.end annotation


# instance fields
.field public final synthetic a:Lrb/r0$j;

.field public final synthetic b:Lrb/p;

.field public final synthetic c:Ltb/g1$s;


# direct methods
.method public constructor <init>(Ltb/g1$s;Lrb/r0$j;Lrb/p;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$s$b;->c:Ltb/g1$s;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/g1$s$b;->a:Lrb/r0$j;

    .line 4
    .line 5
    iput-object p3, p0, Ltb/g1$s$b;->b:Lrb/p;

    .line 6
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    .line 9
    .line 10
    return-void
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
    .line 89
    .line 90
    .line 91
    .line 92
    .line 93
    .line 94
    .line 95
    .line 96
    .line 97
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 1
    iget-object v0, p0, Ltb/g1$s$b;->c:Ltb/g1$s;

    .line 2
    .line 3
    iget-object v1, v0, Ltb/g1$s;->b:Ltb/g1;

    .line 4
    .line 5
    invoke-static {v1}, Ltb/g1;->w0(Ltb/g1;)Ltb/g1$s;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    if-eq v0, v1, :cond_0

    .line 10
    .line 11
    goto :goto_0

    .line 12
    :cond_0
    iget-object v0, p0, Ltb/g1$s$b;->c:Ltb/g1$s;

    .line 13
    .line 14
    iget-object v0, v0, Ltb/g1$s;->b:Ltb/g1;

    .line 15
    .line 16
    iget-object v1, p0, Ltb/g1$s$b;->a:Lrb/r0$j;

    .line 17
    .line 18
    invoke-static {v0, v1}, Ltb/g1;->X(Ltb/g1;Lrb/r0$j;)V

    .line 19
    .line 20
    .line 21
    iget-object v0, p0, Ltb/g1$s$b;->b:Lrb/p;

    .line 22
    .line 23
    sget-object v1, Lrb/p;->e:Lrb/p;

    .line 24
    .line 25
    if-eq v0, v1, :cond_1

    .line 26
    .line 27
    iget-object v0, p0, Ltb/g1$s$b;->c:Ltb/g1$s;

    .line 28
    .line 29
    iget-object v0, v0, Ltb/g1$s;->b:Ltb/g1;

    .line 30
    .line 31
    invoke-static {v0}, Ltb/g1;->z(Ltb/g1;)Lrb/f;

    .line 32
    .line 33
    .line 34
    move-result-object v0

    .line 35
    sget-object v1, Lrb/f$a;->b:Lrb/f$a;

    .line 36
    .line 37
    iget-object v2, p0, Ltb/g1$s$b;->b:Lrb/p;

    .line 38
    .line 39
    iget-object v3, p0, Ltb/g1$s$b;->a:Lrb/r0$j;

    .line 40
    .line 41
    filled-new-array {v2, v3}, [Ljava/lang/Object;

    .line 42
    .line 43
    .line 44
    move-result-object v2

    .line 45
    const-string v3, "Entering {0} state with picker: {1}"

    .line 46
    .line 47
    invoke-virtual {v0, v1, v3, v2}, Lrb/f;->b(Lrb/f$a;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 48
    .line 49
    .line 50
    iget-object v0, p0, Ltb/g1$s$b;->c:Ltb/g1$s;

    .line 51
    .line 52
    iget-object v0, v0, Ltb/g1$s;->b:Ltb/g1;

    .line 53
    .line 54
    invoke-static {v0}, Ltb/g1;->W(Ltb/g1;)Ltb/x;

    .line 55
    .line 56
    .line 57
    move-result-object v0

    .line 58
    iget-object v1, p0, Ltb/g1$s$b;->b:Lrb/p;

    .line 59
    .line 60
    invoke-virtual {v0, v1}, Ltb/x;->b(Lrb/p;)V

    .line 61
    .line 62
    .line 63
    :cond_1
    :goto_0
    return-void
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
.end method
