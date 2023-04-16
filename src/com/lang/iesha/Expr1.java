package com.lang.iesha;

import java.util.List;
abstract class Expr1 {
   interface Visitor<R> {
   R visitBinaryExpr1(Binary expr1);
   R visitGroupingExpr1(Grouping expr1);
   R visitLiteralExpr1(Literal expr1);
   R visitUnaryExpr1(Unary expr1);

  }
   static class Binary extends Expr1  {
    Binary(Expr1 left, Token operator, Expr1 right)  {
     this.left = left;
     this.operator = operator;
     this.right = right;
     }

   final Expr1 left;
   final Token operator;
   final Expr1 right;
   @Override
   <R> R accept(Visitor<R> visitor) {
    return visitor.visitBinaryExpr1(this);
   }
  }
   static class Grouping extends Expr1  {
    Grouping(Expr1 expression)  {
     this.expression = expression;
     }

   final Expr1 expression;
   @Override
   <R> R accept(Visitor<R> visitor) {
    return visitor.visitGroupingExpr1(this);
   }
  }
   static class Literal extends Expr1  {
    Literal(Object value)  {
     this.value = value;
     }

   final Object value;
   @Override
   <R> R accept(Visitor<R> visitor) {
    return visitor.visitLiteralExpr1(this);
   }
  }
   static class Unary extends Expr1  {
    Unary(Token operator, Expr1 right)  {
     this.operator = operator;
     this.right = right;
     }

   final Token operator;
   final Expr1 right;
   @Override
   <R> R accept(Visitor<R> visitor) {
    return visitor.visitUnaryExpr1(this);
   }
  }

  abstract <R> R accept(Visitor<R> visitor);
   }
