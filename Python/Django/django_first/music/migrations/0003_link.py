# -*- coding: utf-8 -*-
# Generated by Django 1.9 on 2016-10-30 06:08
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('music', '0002_song_is_faborite'),
    ]

    operations = [
        migrations.CreateModel(
            name='Link',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('page_id', models.IntegerField()),
                ('link', models.CharField(max_length=250)),
            ],
        ),
    ]