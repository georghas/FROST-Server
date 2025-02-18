/*
 * Copyright (C) 2024 Fraunhofer Institut IOSB, Fraunhoferstr. 1, D 76131
 * Karlsruhe, Germany.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.fraunhofer.iosb.ilt.frostserver.service;

import de.fraunhofer.iosb.ilt.frostserver.settings.CoreSettings;

/**
 * The interface that extensions (plug-ins) should implement so they can be
 * properly registered.
 *
 * Extensions must have a no-args constructor that is side-effect free. This
 * constructor will be used to create an initial instance that is then
 * initialised.
 *
 * @author scf
 */
public interface Plugin {

    /**
     * Initialise the plugin using settings from the given CoreSettings.
     *
     * @param settings The settings to use.
     * @return the result of the initialisation.
     */
    public InitResult init(CoreSettings settings);

    /**
     * Check if this plugin is enabled.
     *
     * @return true if this plugin is enabled.
     */
    public boolean isEnabled();

}
