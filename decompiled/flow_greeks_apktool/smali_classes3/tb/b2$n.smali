.class public Ltb/b2$n;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ltb/b2$r;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltb/b2;->n0(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "n"
.end annotation


# instance fields
.field public final synthetic a:Ljava/lang/Object;

.field public final synthetic b:Ltb/b2;


# direct methods
.method public constructor <init>(Ltb/b2;Ljava/lang/Object;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/b2$n;->b:Ltb/b2;

    .line 2
    .line 3
    iput-object p2, p0, Ltb/b2$n;->a:Ljava/lang/Object;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
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
.end method


# virtual methods
.method public a(Ltb/b2$c0;)V
    .locals 3

    .line 1
    iget-object v0, p1, Ltb/b2$c0;->a:Ltb/r;

    .line 2
    .line 3
    iget-object v1, p0, Ltb/b2$n;->b:Ltb/b2;

    .line 4
    .line 5
    invoke-static {v1}, Ltb/b2;->v(Ltb/b2;)Lrb/z0;

    .line 6
    .line 7
    .line 8
    move-result-object v1

    .line 9
    iget-object v2, p0, Ltb/b2$n;->a:Ljava/lang/Object;

    .line 10
    .line 11
    invoke-virtual {v1, v2}, Lrb/z0;->j(Ljava/lang/Object;)Ljava/io/InputStream;

    .line 12
    .line 13
    .line 14
    move-result-object v1

    .line 15
    invoke-interface {v0, v1}, Ltb/o2;->n(Ljava/io/InputStream;)V

    .line 16
    .line 17
    .line 18
    iget-object p1, p1, Ltb/b2$c0;->a:Ltb/r;

    .line 19
    .line 20
    invoke-interface {p1}, Ltb/o2;->flush()V

    .line 21
    .line 22
    .line 23
    return-void
    .line 24
    .line 25
    .line 26
.end method
