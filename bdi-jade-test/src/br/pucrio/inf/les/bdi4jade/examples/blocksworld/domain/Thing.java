//----------------------------------------------------------------------------
// Copyright (C) 2011  Ingrid Nunes, et al.
// 
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
// 
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
// 
// To contact the authors:
// http://www.inf.puc-rio.br/~ionunes/
//
//----------------------------------------------------------------------------
package br.pucrio.inf.les.bdi4jade.examples.blocksworld.domain;

/**
 * @author ingrid
 * 
 */
public interface Thing {

	public static final Table TABLE = new Table();
	public static final Block BLOCK_1 = new Block(1);
	public static final Block BLOCK_2 = new Block(2);
	public static final Block BLOCK_3 = new Block(3);
	public static final Block BLOCK_4 = new Block(4);
	public static final Block BLOCK_5 = new Block(5);
	public static final Block BLOCK_6 = new Block(6);
	public static final Block BLOCK_7 = new Block(7);
	public static final Block BLOCK_8 = new Block(8);
	public static final Block BLOCK_9 = new Block(9);
	public static final Thing[] THINGS = { TABLE, BLOCK_1, BLOCK_2, BLOCK_3,
			BLOCK_4, BLOCK_5, BLOCK_6, BLOCK_7, BLOCK_8, BLOCK_9 };

}
