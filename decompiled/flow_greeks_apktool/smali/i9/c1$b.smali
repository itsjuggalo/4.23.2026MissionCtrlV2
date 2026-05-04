.class public Li9/c1$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Li9/c1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "b"
.end annotation


# instance fields
.field public final synthetic a:Li9/c1;


# direct methods
.method public constructor <init>(Li9/c1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Li9/c1$b;->a:Li9/c1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Li9/c1;Li9/c1$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Li9/c1$b;-><init>(Li9/c1;)V

    return-void
.end method


# virtual methods
.method public iterator()Ljava/util/Iterator;
    .locals 2

    .line 1
    iget-object v0, p0, Li9/c1$b;->a:Li9/c1;

    .line 2
    .line 3
    invoke-static {v0}, Li9/c1;->g(Li9/c1;)Lg8/c;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Lg8/c;->iterator()Ljava/util/Iterator;

    .line 8
    .line 9
    .line 10
    move-result-object v0

    .line 11
    new-instance v1, Li9/c1$b$a;

    .line 12
    .line 13
    invoke-direct {v1, p0, v0}, Li9/c1$b$a;-><init>(Li9/c1$b;Ljava/util/Iterator;)V

    .line 14
    .line 15
    .line 16
    return-object v1
.end method
