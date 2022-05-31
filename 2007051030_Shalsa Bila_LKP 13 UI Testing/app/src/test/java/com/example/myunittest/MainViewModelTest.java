package com.example.myunittest;

import static org.mockito.Mockito.mock;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class MainViewModelTest extends TestCase {

        private MainViewModel mainViewModel;
        private TabungModel tabungModel;

        private final double dummyLength = 10.0;
        private final double dummyHeight = 20.0;
        private final double dummyVolume = 6280.0;
        private final double dummyLuasSelimut = 1256.0;
        private final double dummyLuasTabung = 1884.0;

        @Before
        public void before() {
            tabungModel = mock(TabungModel.class);
            mainViewModel = new MainViewModel(tabungModel);
        }

        @Test
        public void testVolume() {
            tabungModel = new TabungModel();
            mainViewModel = new MainViewModel(tabungModel);
            mainViewModel.hitung(dummyLength, dummyHeight);
            double volume = mainViewModel.volume();
            assertEquals(dummyVolume, volume, 0.0001);
        }
        @Test
        public void testLuasSelimut() {
            tabungModel = new TabungModel();
            mainViewModel = new MainViewModel(tabungModel);
            mainViewModel.hitung(dummyLength, dummyHeight);
            double volume = mainViewModel.luasSelimut();
            assertEquals(dummyLuasSelimut, volume, 0.0001);
        }
        @Test
        public void testLuasTabung() {
            tabungModel = new TabungModel();
            mainViewModel = new MainViewModel(tabungModel);
            mainViewModel.hitung(dummyLength, dummyHeight);
            double volume = mainViewModel.luasTabung();
            assertEquals(dummyLuasTabung, volume, 0.00001);
        }
    }
