package com.bralogrithm.never_another.model;

/*
 * Lavet af Sylvester
 *
 * Bruges til hver side i flowet. Denne klasse ser bort fra om det er text eller et video flow som er aktivt.
 * Det styres af FlowViewModel
 *
 */

public enum Flow {
    Intro,
    UpperSize,
    UnderSize,
    BreastSize,
    BreastHeight,
    CheckSizes,
    OrdreConfirmed
}
