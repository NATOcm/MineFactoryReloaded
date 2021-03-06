package powercrystals.minefactoryreloaded.tile;

import cpw.mods.fml.common.network.PacketDispatcher;
import powercrystals.core.block.IAirDropTarget;
import powercrystals.core.net.PacketWrapper;
import powercrystals.core.position.IRotateableTile;
import powercrystals.minefactoryreloaded.MineFactoryReloadedCore;
import powercrystals.minefactoryreloaded.net.Packets;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class TileEntityConveyor extends TileEntity implements IRotateableTile, IAirDropTarget
{
	private int _dye = -1;
	
	public int getDyeColor()
	{
		return _dye;
	}
	
	public void setDyeColor(int dye)
	{
		if(worldObj != null && !worldObj.isRemote && _dye != dye)
		{
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			PacketDispatcher.sendPacketToAllAround(xCoord, yCoord, zCoord, 50, worldObj.provider.dimensionId, getDescriptionPacket());
		}
		_dye = dye;
	}
	
	@Override
	public Packet getDescriptionPacket()
	{
		return PacketWrapper.createPacket(MineFactoryReloadedCore.modNetworkChannel, Packets.ConveyorDescription, new Object[] { xCoord, yCoord, zCoord, _dye });
	}
	
	@Override
	public void rotate()
	{
		int md = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		if(md == 0)
		{
			int nextBlockId = worldObj.getBlockId(xCoord + 1, yCoord, zCoord);
			int prevBlockId = worldObj.getBlockId(xCoord - 1, yCoord, zCoord);
			if(Block.blocksList[nextBlockId] != null && Block.blocksList[nextBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 4);
			}
			else if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 8);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 1);
			}
		}
		else if(md == 4)
		{
			int prevBlockId = worldObj.getBlockId(xCoord - 1, yCoord, zCoord);
			if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 8);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 1);
			}
		}
		else if(md == 8)
		{
			rotateTo(worldObj, xCoord, yCoord, zCoord, 1);
		}
		

		if(md == 1)
		{
			int nextBlockId = worldObj.getBlockId(xCoord, yCoord, zCoord + 1);
			int prevBlockId = worldObj.getBlockId(xCoord, yCoord, zCoord - 1);
			if(Block.blocksList[nextBlockId] != null && Block.blocksList[nextBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 5);
			}
			else if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 9);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 2);
			}
		}
		else if(md == 5)
		{
			int prevBlockId = worldObj.getBlockId(xCoord, yCoord, zCoord - 1);
			if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 9);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 2);
			}
		}
		else if(md == 9)
		{
			rotateTo(worldObj, xCoord, yCoord, zCoord, 2);
		}
		

		if(md == 2)
		{
			int nextBlockId = worldObj.getBlockId(xCoord - 1, yCoord, zCoord);
			int prevBlockId = worldObj.getBlockId(xCoord + 1, yCoord, zCoord);
			if(Block.blocksList[nextBlockId] != null && Block.blocksList[nextBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 6);
			}
			else if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 10);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 3);
			}
		}
		else if(md == 6)
		{
			int prevBlockId = worldObj.getBlockId(xCoord + 1, yCoord, zCoord);
			if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 10);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 3);
			}
		}
		else if(md == 10)
		{
			rotateTo(worldObj, xCoord, yCoord, zCoord, 3);
		}
		

		if(md == 3)
		{
			int nextBlockId = worldObj.getBlockId(xCoord, yCoord, zCoord - 1);
			int prevBlockId = worldObj.getBlockId(xCoord, yCoord, zCoord + 1);
			if(Block.blocksList[nextBlockId] != null && Block.blocksList[nextBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 7);
			}
			else if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 11);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 0);
			}
		}
		else if(md == 7)
		{
			int prevBlockId = worldObj.getBlockId(xCoord, yCoord, zCoord + 1);
			if(Block.blocksList[prevBlockId] != null && Block.blocksList[prevBlockId].isOpaqueCube())
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 11);
			}
			else
			{
				rotateTo(worldObj, xCoord, yCoord, zCoord, 0);
			}
		}
		else if(md == 11)
		{
			rotateTo(worldObj, xCoord, yCoord, zCoord, 0);
		}
	}
	
	private void rotateTo(World world, int xCoord, int yCoord, int zCoord, int newmd)
	{
		world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, newmd, 2);
	}

	@Override
	public boolean canRotate()
	{
		return true;
	}

	@Override
	public ForgeDirection getDirectionFacing() 
	{
		return ForgeDirection.UNKNOWN;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		
		nbtTagCompound.setInteger("dyeColor", _dye);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		
		if(nbtTagCompound.hasKey("dyeColor"))
		{
			_dye = nbtTagCompound.getInteger("dyeColor");
		}
	}
}
